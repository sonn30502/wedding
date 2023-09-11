/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.repository.Impl;

import com.dcs.pojos.Feedback;
import com.dcs.repository.FeedbackRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
@Repository
@Transactional
public class FeedbackRepositoryImpl implements FeedbackRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private SimpleDateFormat simpleDateFormat;

    @Override
    public void updateFeedback(Feedback feedback) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            feedback.setFeedbackDate(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
            if (feedback.getFeedbackID() == null) {
                s.save(feedback);
            } else {
                s.update(feedback);
            }
        } catch (ParseException ex) {
            Logger.getLogger(FeedbackRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        Session session = this.factory.getObject().getCurrentSession();
        Query<Feedback> query = session.createQuery("FROM Feedback", Feedback.class);
        List<Feedback> feedbacks = query.getResultList();
        return feedbacks;
    }

}
