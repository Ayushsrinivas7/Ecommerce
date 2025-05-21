package com.example.ecommerce.service;

import com.example.ecommerce.dto.OrderDTO;
import com.example.ecommerce.dto.OrderRequest;

import java.util.List;

public interface OrderService {
    OrderDTO placeOrder(OrderRequest request);
    List<OrderDTO> getOrderHistory(String userId, int page, int size);
}
