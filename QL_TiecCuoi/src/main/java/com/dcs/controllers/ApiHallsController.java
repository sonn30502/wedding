/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.controllers;

import com.dcs.pojos.Halls;
import com.dcs.service.BranchService;
import com.dcs.service.HallsService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api")
public class ApiHallsController {

    @Autowired
    private HallsService hallsService;
    @Autowired
    private BranchService branchService;

    @DeleteMapping("/halls/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "id") int id) {
        this.hallsService.deleteHall(id);
    }

    @RequestMapping("/halls/")
    @CrossOrigin
    public ResponseEntity<List<Halls>> list(@RequestParam Map<String, String> params) {
        List<Halls> h = hallsService.getHall(params);
        return new ResponseEntity<>(h, HttpStatus.OK);
    }

    @RequestMapping(path = "/halls/{hallID}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Halls> details(@PathVariable(value = "hallID") int id) {
        return new ResponseEntity<>(this.hallsService.getHallById(id), HttpStatus.OK);
    }

//    @PostMapping(path = "/halls", consumes = {
//        MediaType.MULTIPART_FORM_DATA_VALUE,
//        MediaType.APPLICATION_JSON_VALUE
//    })
//    @ResponseStatus(HttpStatus.CREATED)
//    public void add(@RequestParam Map<String, String> params, @RequestPart MultipartFile[] file) {
//        Halls h = new Halls();
//        h.setHallName(params.get("hallName"));
//
//        h.setPriceMorning(new BigDecimal(params.get("priceMorning")));
//        h.setPriceAfternoon(new BigDecimal(params.get("priceAfternoon")));
//        h.setPriceEvening(new BigDecimal(params.get("priceEvening")));
//        h.setPriceWeekend(new BigDecimal(params.get("priceWeekend")));
//        h.setDescription(params.get("description"));
//        int branchID = Integer.parseInt(params.get("branchID"));
//        h.setBranchID(this.branchService.getBranchById(branchID));
//
//        if (file.length > 0) {
//            h.setFile(file[0]);
//        }
//
//        this.hallsService.addOrUpdateHall(h);
//    }

}
