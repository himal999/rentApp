package lk.rent.app.controller;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.DiscountDTO;
import lk.rent.app.service.DiscountService;
import lk.rent.app.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("discount")
@CrossOrigin
public class DiscountController {
    @Autowired
    DiscountService discountService;

    @PostMapping(path = "/newDiscount", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil newDiscount(@RequestBody DiscountDTO discountDTO) {
        discountService.addDiscount(discountDTO);
        return new ResponseUtil(200, "success", null);
    }

    @GetMapping(path = "/allDiscount", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDiscount() {
        return new ResponseUtil(200, "success", discountService.getDiscount());
    }

    @PutMapping(path = "/updateDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDiscount(@RequestBody DiscountDTO discountDTO) {
        discountService.updateDiscount(discountDTO);
        return new ResponseUtil(200, "success", discountService.findDiscount(discountDTO.getDiscountID()));
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteDiscount(@PathVariable("id") String id) {
        discountService.deleteDiscount(id);
        return new ResponseUtil(200, "success", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findDiscount(@PathVariable("id") String id) {

        return new ResponseUtil(200, "success", discountService.findDiscount(id));
    }
}
