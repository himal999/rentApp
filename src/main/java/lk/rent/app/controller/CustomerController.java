package lk.rent.app.controller;/*
author :Himal
version : 0.0.1
*/


import lk.rent.app.dto.CustomerDTO;
import lk.rent.app.service.CustomerService;
import lk.rent.app.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(path = "/newCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil newCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.addCustomer(customerDTO);
        return new ResponseUtil(200, "success", null);
    }

    @GetMapping(path = "/allCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomer() {
        return new ResponseUtil(200, "success", customerService.getCustomer());
    }

    @PutMapping(path = "/updateDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(customerDTO);
        return new ResponseUtil(200, "success", customerService.findCustomer(customerDTO.getNic()));
    }
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCustomer(@PathVariable("id") String id) {
        customerService.deleteCustomer(id);
        return new ResponseUtil(200, "success",null);
    }
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findCustomer(@PathVariable("id") String id) {

        return new ResponseUtil(200, "success",customerService.findCustomer(id));
    }
}
