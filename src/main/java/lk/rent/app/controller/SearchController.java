package lk.rent.app.controller;/*
author :Himal
version : 0.0.1
*/

import lk.rent.app.dto.SearchDTO;
import lk.rent.app.service.SearchService;
import lk.rent.app.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("find")
@CrossOrigin
public class SearchController {

    @Autowired
    SearchService searchService;

    @PostMapping(path = "/pp",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findAvailableVehicles(@RequestBody SearchDTO searchDTO) {
        System.out.println(searchDTO.toString());
        return new ResponseUtil(200, "Ok", searchService.findAvailableVehicle(searchDTO));
    }
}
