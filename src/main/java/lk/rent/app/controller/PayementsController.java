package lk.rent.app.controller;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.PayementsDTO;
import lk.rent.app.service.PayementsService;
import lk.rent.app.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payements")
@CrossOrigin
public class PayementsController {
    @Autowired
    PayementsService payementsService;

    @PostMapping(path = "/newPayements", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil newPayements(@RequestBody PayementsDTO payementsDTO) {
        payementsService.addPayements(payementsDTO);
        return new ResponseUtil(200, "success", null);
    }

    @GetMapping(path = "/allPayements", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllPayements() {
        return new ResponseUtil(200, "success", payementsService.getPayements());
    }

    @PutMapping(path = "/updateDetails", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updatePayements(@RequestBody PayementsDTO payementsDTO) {
        payementsService.updatePayements(payementsDTO);
        return new ResponseUtil(200, "success", payementsService.findPayements(payementsDTO.getId()));
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deletePayements(@PathVariable("id") String id) {
        payementsService.deletePayements(id);
        return new ResponseUtil(200, "success", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findPayements(@PathVariable("id") String id) {
        return new ResponseUtil(200, "success", payementsService.findPayements(id));
    }
}
