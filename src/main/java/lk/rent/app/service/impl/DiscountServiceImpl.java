package lk.rent.app.service.impl;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.DiscountDTO;
import lk.rent.app.entity.Discount;
import lk.rent.app.repo.DiscountRepo;
import lk.rent.app.service.DiscountService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DiscountServiceImpl implements DiscountService {
    @Autowired
    DiscountRepo discountRepo;
    @Autowired
    ModelMapper mapper;

    @Override
    public void addDiscount(DiscountDTO discountDTO) {
        if (!discountRepo.existsById(discountDTO.getDiscountID())) {
            discountRepo.save(mapper.map(discountDTO, Discount.class));
        } else {
            throw new RuntimeException("Discount " + discountDTO.getDiscountID() + " Already Exists !!!");
        }
    }

    @Override
    public void updateDiscount(DiscountDTO discountDTO) {
        if (discountRepo.existsById(discountDTO.getDiscountID())) {
            discountRepo.save(mapper.map(discountDTO, Discount.class));
        } else {
            throw new RuntimeException("Please Register first !!!");
        }
    }

    @Override
    public List<DiscountDTO> getDiscount() {
        return mapper.map(discountRepo.findAll(), new TypeToken<List<DiscountDTO>>() {
        }.getType());
    }

    @Override
    public void deleteDiscount(String id) {
        if (discountRepo.existsById(id)) {
            discountRepo.deleteById(id);
        } else {
            throw new RuntimeException("Can't remove Discount,Please not Register Discount yet!!!");
        }

    }

    @Override
    public DiscountDTO findDiscount(String id) {
        if (discountRepo.existsById(id)) {
            return mapper.map(discountRepo.findById(id), DiscountDTO.class);
        } else {
            throw new RuntimeException("Can't find Discount,Please not Register Discount yet!!!");
        }
    }
}
