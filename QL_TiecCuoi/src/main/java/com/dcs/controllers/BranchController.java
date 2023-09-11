/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.controllers;

import com.dcs.pojos.Branch;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.dcs.service.BranchService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ASUS
 */
@Controller
@RequestMapping("/admin")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping("/branch")
    public String list(Model model) {
        model.addAttribute("branch", new Branch());
        return "branch";

    }

    @GetMapping("/branch/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("branch", this.branchService.getBranchById(id));
        return "branch";
    }

    @PostMapping("/branch")
    public String add(@ModelAttribute(value = "branch") @Valid Branch branch,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            if (branchService.addOrUpdateBranch(branch)) {
                return "redirect:/list_branch";
            }
        }

        return "branch";
    }

    @GetMapping("/branch/delete/{id}")
    public String delete(@PathVariable(value = "id") int id) {
        branchService.deleteBranch(id);
        return "redirect:/list_branch";
    }

}
