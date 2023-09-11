/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.service.Impl;

import com.dcs.pojos.Feedback;
import com.dcs.repository.FeedbackRepository;
import com.dcs.service.FeedbackService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public void updateFeedback(Feedback feedback) {
        this.feedbackRepository.updateFeedback(feedback);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return this.feedbackRepository.getAllFeedbacks();
    }

}
