package com.phoneshop.shop.controller;

import com.phoneshop.shop.entity.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/phone")
@CrossOrigin(origins = "*", exposedHeaders = "Authorization")
public class PhoneController {
    private static final String UPLOAD_DIR = "D:/nnshop/New folder/mobile-phone-shop/src/assets/img/upload";
    String tempOne;
    @Autowired
    com.phoneshop.shop.service.PhoneService phoneService;

    @GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public com.phoneshop.shop.util.ResponseUtil getAllPhones() {
        return new com.phoneshop.shop.util.ResponseUtil(200, "Ok", phoneService.getAllPhones());
    }

    @GetMapping(path = "/getLast", produces = MediaType.APPLICATION_JSON_VALUE)
    public com.phoneshop.shop.util.ResponseUtil getLastPhone() {
        return new com.phoneshop.shop.util.ResponseUtil(200, "Ok", phoneService.getLastRecord());
    }

    @ResponseStatus(HttpStatus.CREATED) //201
    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE)
    public com.phoneshop.shop.util.ResponseUtil savePhone(@RequestBody com.phoneshop.shop.dto.PhoneDTO phone) {
        System.out.println("awaa");
        System.out.println(phone.getQuatity());
        phone.setImage1(tempOne);

        Phone phone1 = new Phone();
        phone1.setId(phone.getId());
        phone1.setName(phone.getName());
        phone1.setBrand(phone.getBrand());
        phone1.setQuatity(phone.getQuatity());
        phone1.setPrice(phone.getPrice());
        phone1.setImage1(tempOne);

        phoneService.savePhone(phone1);
        return new com.phoneshop.shop.util.ResponseUtil(200, "Save", null);
    }


    @PutMapping(path = "/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public com.phoneshop.shop.util.ResponseUtil updatePhone(@RequestBody com.phoneshop.shop.dto.PhoneDTO phone) {

        Phone phone1 = new Phone();
        phone1.setId(phone.getId());
        phone1.setName(phone.getName());
        phone1.setBrand(phone.getBrand());
        phone1.setQuatity(phone.getQuatity());
        phone1.setPrice(phone.getPrice());
        phone1.setImage1(tempOne);

        phoneService.updatePhone(phone1);
        return new com.phoneshop.shop.util.ResponseUtil(200, "Updated", null);
    }

    @PutMapping(path = "/editWithOrder", produces = MediaType.APPLICATION_JSON_VALUE)
    public com.phoneshop.shop.util.ResponseUtil updatePhoneOrder(@RequestBody com.phoneshop.shop.dto.PhoneDTO phone) {

        Phone phone1 = new Phone();
        phone1.setId(phone.getId());
        phone1.setName(phone.getName());
        phone1.setBrand(phone.getBrand());
        phone1.setQuatity(phone.getQuatity());
        phone1.setPrice(phone.getPrice());
        phone1.setImage1(phone.getImage1());

        phoneService.updatePhone(phone1);
        return new com.phoneshop.shop.util.ResponseUtil(200, "Updated", null);
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public com.phoneshop.shop.util.ResponseUtil deletePhone(@RequestParam String id) {
        phoneService.deletePhone(id);
        return new com.phoneshop.shop.util.ResponseUtil(200, "Deleted", null);
    }

    @GetMapping(path = "/get", params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public com.phoneshop.shop.util.ResponseUtil searchPhone(@RequestParam String id) {
        System.out.println(id);
        return new com.phoneshop.shop.util.ResponseUtil(200, "Ok", phoneService.searchPhone(id));
    }


    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("myFile") MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            tempOne = fileName;

            File directory = new File(UPLOAD_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            Path filePath = Paths.get(UPLOAD_DIR, fileName);

            Files.write(filePath, file.getBytes());

            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload the image!";
        }
    }


}


