package com.example.ecommerce.service;

import com.example.ecommerce.dto.AddToCartRequest;
import com.example.ecommerce.dto.CartItemDTO;

import java.util.List;

public interface CartService {
    CartItemDTO addToCart(AddToCartRequest request);
    void removeFromCart(Long cartItemId);
    List<CartItemDTO> getCartItems(String userId);
}
