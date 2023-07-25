package com.phoneshop.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OrderDTO {
    private int id;
    private String userId;
    private String phoneId;
    private String name;
    private String brand;
    private String price;
    private String image1;
    private String quantity;
    private String type;
}
