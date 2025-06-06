package com.example.ecommerce.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {
    private Long id;
    private String userId;
    private Double totalPrice;
    private LocalDateTime orderDate;
    private String status;
    private List<OrderItemDTO> items;
}
