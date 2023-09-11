/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.controllers;

import com.dcs.pojos.Service;
import com.dcs.service.BranchService;
import com.dcs.service.DVService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RequestMapping("/api")
@RestController
public class ApiDVController {

    @Autowired
    private DVService dvService;

    @Autowired
    private BranchService branchService;

    @RequestMapping("/service/")
    @CrossOrigin
    private ResponseEntity<List<Service>> list(@RequestParam Map<String, String> params) {
        List<Service> dv = dvService.getAllService(params);
        return new ResponseEntity<>(dv, HttpStatus.OK);
    }

    @RequestMapping(path = "/service/{serviceID}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Service> details(@PathVariable(value = "serviceID") int id) {
        Service s = dvService.getServiceById(id);
        if (s == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(s, HttpStatus.OK);
    }
}
