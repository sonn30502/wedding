/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.controllers;

import com.dcs.pojos.Menu;
import com.dcs.service.BranchService;
import com.dcs.service.MenuService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ASUS
 */
@Controller
@RequestMapping("/admin")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private BranchService branchService;

    @GetMapping("/menu")
    public String list(Model model) {
        model.addAttribute("menu", new Menu());
        model.addAttribute("branchList", branchService.getAllBranch());
        return "menu";
    }

    @GetMapping("/menu/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("menu", this.menuService.getMenuById(id));
        model.addAttribute("branchList", branchService.getAllBranch());
        return "menu";
    }

    @PostMapping("/menu")
    public String add(Model model, @ModelAttribute(value = "menu") @Valid Menu menu,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            if (menuService.addOrUpdateMenu(menu) == true) {
                return "redirect:/list_menu";
            }
        }
        model.addAttribute("branchList", branchService.getAllBranch());
        return "menu";
    }

    @GetMapping("/menu/delete/{id}")
    public String delete(@PathVariable(value = "id") int id) {
        menuService.deleteMenu(id);
        return "redirect:/list_menu";
    }
}
