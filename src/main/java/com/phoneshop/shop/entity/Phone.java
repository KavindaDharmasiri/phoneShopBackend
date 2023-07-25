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
@Table(name = "PHONE_TBL")
public class Phone {
    @Id
    private int id;
    private String name;
    private String brand;
    private String quatity;
    private String price;
    private String image1;
}
