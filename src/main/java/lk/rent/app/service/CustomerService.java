package lk.rent.app.service;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.CustomerDTO;


import java.util.List;


public interface CustomerService {
    void addCustomer(CustomerDTO customerDTO);
    void updateCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getCustomer();
    void deleteCustomer(String id);
    CustomerDTO findCustomer(String id);
}
