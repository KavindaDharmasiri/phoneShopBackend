package com.phoneshop.shop.service.impl;

import com.phoneshop.shop.dto.PhoneDTO;
import com.phoneshop.shop.entity.Phone;
import com.phoneshop.shop.repository.PhoneRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PhoneServiceImpl implements com.phoneshop.shop.service.PhoneService {

    @Autowired
    private PhoneRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void savePhone(Phone dto) {
        System.out.println(dto.getId());
        repo.save(mapper.map(dto, Phone.class));
    }

    @Override
    public void deletePhone(String ids) {
        int id = Integer.parseInt(ids);
        if (repo.existsById(id)) {
            repo.deleteById(id);
        } else {
            throw new RuntimeException("Please check the Phone id number.. No Such Phone..!");
        }
    }

    @Override
    public void updatePhone(Phone dto) {
        repo.save(mapper.map(dto, Phone.class));

    }

    @Override
    public PhoneDTO searchPhone(String id) {
        int i = Integer.parseInt(id);
        Phone byId = repo.findById(i);
        PhoneDTO phoneDTO = new PhoneDTO();
        phoneDTO.setId(byId.getId());
        phoneDTO.setName(byId.getName());
        phoneDTO.setBrand(byId.getBrand());
        phoneDTO.setImage1(byId.getImage1());
        phoneDTO.setQuatity(byId.getQuatity());
        phoneDTO.setPrice(byId.getPrice());
        return phoneDTO;
    }

    @Override
    public List<PhoneDTO> getAllPhones() {
        return mapper.map(repo.findAll(), new TypeToken<List<PhoneDTO>>() {
        }.getType());
    }

    @Override
    public Phone getLastRecord() {
        return repo.findFirstByOrderByIdDesc();
    }
}
