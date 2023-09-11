/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.controllers;

import com.dcs.pojos.User;
import com.dcs.service.UserService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */
@Controller
public class UserController {

    @Autowired
    private UserService userDetailsService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "user") User user) {
        String errMsg = "";
        // Trích xuất các thông tin cần thiết từ đối tượng User
        Map<String, String> params = new HashMap<>();
        params.put("firstName", user.getFirstName());
        params.put("lastName", user.getLastName());
        params.put("phoneNumber", user.getPhoneNumber());
        params.put("email", user.getEmail());
        params.put("username", user.getUsername());
        params.put("password", user.getPassword());

        MultipartFile profileImage = user.getFile();

        User addedUser = this.userDetailsService.addUser(params, profileImage);

        if (addedUser != null) {
            return "redirect:/login";
        } else {
            errMsg = "Đã có lỗi xảy ra";
        }

        model.addAttribute("errMsg", errMsg);
        return "register";
    }
}
