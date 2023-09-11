/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.controllers;

import com.dcs.pojos.Branch;
import com.dcs.service.BranchService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@RequestMapping("/api")
public class ApiBranchController {

    @Autowired
    private BranchService branchService;

    @RequestMapping("/branch/")
    @CrossOrigin
    public ResponseEntity<List<Branch>> list() {
        List<Branch> b = branchService.getAllBranch();
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @RequestMapping(path = "/branch/{branchID}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Branch> details(@PathVariable(value = "branchID") int id) {
        return new ResponseEntity<>(this.branchService.getBranchById(id), HttpStatus.OK);
    }

}
