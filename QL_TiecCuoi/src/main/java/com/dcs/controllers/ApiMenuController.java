/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.controllers;

import com.dcs.pojos.Menu;
import com.dcs.service.BranchService;
import com.dcs.service.MenuService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
public class ApiMenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private BranchService branchService;

    @RequestMapping("/menu/")
    @CrossOrigin
    public ResponseEntity<List<Menu>> list(@RequestParam Map<String, String> params) {
        List<Menu> m = menuService.getMenu(params);
        return new ResponseEntity<>(m, HttpStatus.OK);
    }

    @RequestMapping(path = "/menu/{menuID}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<Menu> details(@PathVariable(value = "menuID") int id) {
        Menu menu = menuService.getMenuById(id);
        if (menu == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(menu, HttpStatus.OK);
    }

//    @PostMapping(path = "/menu", consumes = {
//        MediaType.MULTIPART_FORM_DATA_VALUE,
//        MediaType.APPLICATION_JSON_VALUE
//    })
//    @ResponseStatus(HttpStatus.CREATED)
//    public void add(@RequestParam Map<String, String> params, @RequestPart MultipartFile[] file) {
//        Menu m = new Menu();
//        m.setMenuName(params.get("menuName"));
//        m.setDescription(params.get("description"));
//        m.setPrice(new BigDecimal(params.get("price")));
//
//        int branchID = Integer.parseInt(params.get("branchID"));
//        m.setBranchID(this.branchService.getBranchById(branchID));
//
//        if (file.length > 0) {
//            m.setFile(file[0]);
//        }
//
//        this.menuService.addOrUpdateMenu(m);
//    }
//    @PostMapping(path = "/menu", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<String> add(
//            @RequestParam Map<String, String> params,
//            @RequestPart("file") MultipartFile[] file
//    ) {
//        Menu m = new Menu();
//        m.setMenuName(params.get("menuName"));
//        m.setDescription(params.get("description"));
//        m.setPrice(new BigDecimal(params.get("price")));
//
//        int branchID = Integer.parseInt(params.get("branchID"));
//        m.setBranchID(this.branchService.getBranchById(branchID));
//
////        if (file != null && !file.isEmpty()) {
////            m.setFile(file);
////        }
//        
//        if(file.length > 0){
//            m.setFile(file[0]);
//        }

//        boolean success = this.menuService.addOrUpdateMenu(m);
//        if (success) {
//            return new ResponseEntity<>("Menu added successfully", HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>("Failed to add menu", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}
