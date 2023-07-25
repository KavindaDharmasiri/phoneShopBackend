package com.phoneshop.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString
@Table(name = "ORDER_TBL")
public class Order {
    @Id
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
