package lk.rent.app.service.impl;
/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.CustomerDTO;
import lk.rent.app.entity.Customer;
import lk.rent.app.repo.CustomerRepo;
import lk.rent.app.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    ModelMapper mapper;
    @Autowired
    private CustomerRepo customerRepo;

    public void addCustomer(CustomerDTO customerDTO) {
        if (!customerRepo.existsById(customerDTO.getNic())) {
            customerRepo.save(mapper.map(customerDTO, Customer.class));
        } else {
            throw new RuntimeException("Customer " + customerDTO.getNic() + " Already Exists !!!");
        }
    }

    public void updateCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getNic())) {
            customerRepo.save(mapper.map(customerDTO, Customer.class));
        } else {
            throw new RuntimeException("Please Register first !!!");
        }
    }

    public List<CustomerDTO> getCustomer() {
        return mapper.map(customerRepo.findAll(), new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }

    public void deleteCustomer(String id) {
        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
        } else {
            throw new RuntimeException("Can't remove Customer,Please not Register Customer yet!!!");
        }
    }

    public CustomerDTO findCustomer(String id) {
        if (customerRepo.existsById(id)) {
            return mapper.map(customerRepo.findById(id), CustomerDTO.class);
        } else {
            throw new RuntimeException("Can't find Customer,Please not Register Customer yet!!!");
        }
    }
}
