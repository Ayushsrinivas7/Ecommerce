package com.example.ecommerce.service ;

import com.example.ecommerce.dto.*;
import com.example.ecommerce.entity.*;
import com.example.ecommerce.repository.*;
import com.example.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Override
    public OrderDTO placeOrder(OrderRequest request) {
        List<CartItem> cartItems = cartItemRepository.findAllById(request.getCartItemIds());

        if (cartItems.isEmpty()) {
            throw new RuntimeException("Cart is empty!");
        }

        double total = cartItems.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();

        List<OrderItem> orderItems = new ArrayList<>();
        Order order = Order.builder()
                .userId(request.getUserId())
                .totalPrice(total)
                .orderDate(LocalDateTime.now())
                .status("PLACED")
                .build();

        for (CartItem ci : cartItems) {
            OrderItem orderItem = OrderItem.builder()
                    .order(order)
                    .product(ci.getProduct())
                    .quantity(ci.getQuantity())
                    .build();
            orderItems.add(orderItem);
        }

        order.setItems(orderItems);
        Order saved = orderRepository.save(order);
        cartItemRepository.deleteAll(cartItems); // Clear cart

        return toDTO(saved);
    }

    @Override
    public List<OrderDTO> getOrderHistory(String userId, int page, int size) {
        return orderRepository.findByUserId(userId).stream()
                .skip((long) page * size)
                .limit(size)
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private OrderDTO toDTO(Order order) {
        List<OrderItemDTO> items = order.getItems().stream().map(i -> OrderItemDTO.builder()
                .productId(i.getProduct().getId())
                .productName(i.getProduct().getName())
                .quantity(i.getQuantity())
                .price(i.getProduct().getPrice())
                .build()).toList();

        return OrderDTO.builder()
                .id(order.getId())
                .userId(order.getUserId())
                .orderDate(order.getOrderDate())
                .status(order.getStatus())
                .totalPrice(order.getTotalPrice())
                .items(items)
                .build();
    }
}
