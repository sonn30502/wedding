/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.controllers;

import com.dcs.pojos.Service;
import com.dcs.service.BranchService;
import com.dcs.service.DVService;
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
public class DVController {

    @Autowired
    private DVService dvService;
    @Autowired
    private BranchService branchService;

    @GetMapping("/service")
    public String list(Model model) {
        model.addAttribute("service", new Service());
        model.addAttribute("branches", branchService.getAllBranch());
        return "service";
    }

    @PostMapping("/service")
    public String addService(Model model, @ModelAttribute(value = "service") @Valid Service s,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            if (dvService.addOrUpdateService(s)) {
                return "redirect:/list_service";
            }
        }
        model.addAttribute("branches", branchService.getAllBranch());
        return "service";
    }

    @GetMapping("/service/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("service", this.dvService.getServiceById(id));
        model.addAttribute("branches", branchService.getAllBranch());
        return "service";
    }

    @GetMapping("/service/delete/{id}")
    public String delete(@PathVariable(value = "id") int id) {
        dvService.deleteService(id);
        return "redirect:/service";
    }
}
