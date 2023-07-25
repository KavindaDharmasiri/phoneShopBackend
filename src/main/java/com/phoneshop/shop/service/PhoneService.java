package com.phoneshop.shop.service;

import com.phoneshop.shop.dto.PhoneDTO;
import com.phoneshop.shop.entity.Phone;

import java.util.List;

public interface PhoneService {
    void savePhone(Phone dto);

    void deletePhone(String id);

    void updatePhone(Phone dto);

    PhoneDTO searchPhone(String id);

    List<PhoneDTO> getAllPhones();

    Phone getLastRecord();
}
