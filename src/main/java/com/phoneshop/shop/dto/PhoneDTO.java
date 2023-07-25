package com.phoneshop.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PhoneDTO {
    private int id;
    private String name;
    private String brand;
    private String quatity;
    private String price;
    private String image1;
}
