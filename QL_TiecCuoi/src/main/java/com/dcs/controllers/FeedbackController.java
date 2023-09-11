/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.controllers;

import com.dcs.pojos.Feedback;
import com.dcs.service.EventService;
import com.dcs.service.FeedbackService;
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
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private EventService eventService;

    @GetMapping("/feedbacks")
    public String list(Model model) {
        model.addAttribute("feedback", new Feedback());
        model.addAttribute("eventList", eventService.getAllEvent());
        return "feedbacks";
    }

    @PostMapping("/feedbacks")
    public String addFeedback(Model model, @ModelAttribute(value = "feedback") @Valid Feedback feedback,
            BindingResult rs) {
        if (!rs.hasErrors()) {
            feedbackService.updateFeedback(feedback);
            return "redirect:/feedbacks";
        } else {
            model.addAttribute("eventList", eventService.getAllEvent());
            return "feedbacks";
        }
    }
}
