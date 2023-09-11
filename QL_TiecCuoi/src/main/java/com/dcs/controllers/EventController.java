/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.controllers;

import com.dcs.pojos.Event;
import com.dcs.pojos.Halls;
import com.dcs.pojos.Menu;
import com.dcs.pojos.Service;
import com.dcs.service.BranchService;
import com.dcs.service.DVService;
import com.dcs.service.EventService;
import com.dcs.service.HallsService;
import com.dcs.service.MenuService;
import com.dcs.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ASUS
 */
@Controller
public class EventController {

    @Autowired
    private EventService eventService;
    @Autowired
    private BranchService branchService;
    @Autowired
    private HallsService hallsService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private DVService dvService;
    @Autowired
    private UserService userService;

    @GetMapping("/event")
    public String list(Model model) {
        Map<String, String> params = new HashMap<>();
        List<Halls> hallList = hallsService.getHall(params);
        List<Menu> menuList = menuService.getMenu(params);
        List<Service> dvList = dvService.getAllService(params);
        model.addAttribute("events", new Event());
        model.addAttribute("branchList", branchService.getAllBranch());
        model.addAttribute("hallList", hallList);
        model.addAttribute("menuList", menuList);
        model.addAttribute("dvList", dvList);
        return "event";
    }

    @PostMapping("/event")
    public String addEvent(Model model, @ModelAttribute(value = "events") @Valid Event event,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            eventService.addOrUpdateEvent(event);
            return "redirect:/event";
        } else {
            Map<String, String> params = new HashMap<>();
            List<Halls> hallList = hallsService.getHall(params);
            List<Menu> menuList = menuService.getMenu(params);
            List<Service> dvList = dvService.getAllService(params);
            model.addAttribute("branchList", branchService.getAllBranch());
            model.addAttribute("hallList", hallList);
            model.addAttribute("menuList", menuList);
            model.addAttribute("dvList", dvList);
            return "event";
        }
    }
}
