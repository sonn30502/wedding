/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.repository.Impl;

import com.dcs.pojos.Event;
import static com.dcs.pojos.Event_.hallID;
import com.dcs.repository.EventRepository;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
public class EventRepositoryImpl implements EventRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private SimpleDateFormat simpleDateFormat;

    @Override
    public void addOrUpdateEvent(Event event) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            event.setFeedbackDate(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
            if (event.getEventID() == null) {
                s.save(event);
            } else {
                s.update(event);
            }
        } catch (ParseException ex) {
            Logger.getLogger(EventRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Event getEventById(int eventID) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Event.class, eventID);
    }

    @Override
    public void deleteEvent(Event event) {
        Session s = this.factory.getObject().getCurrentSession();
        s.delete(event);
    }

    @Override
    public List<Event> searchEventsByCriteria(Map<String, Object> criteria) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Event> query = builder.createQuery(Event.class);
        Root<Event> root = query.from(Event.class);
        query.select(root);

        List<Predicate> predicates = new ArrayList<>();

        // Tìm kiếm theo sảnh
        if (criteria.containsKey("hallID")) {
            int hallID = (int) criteria.get("hallID");
            Predicate hallPredicate = builder.equal(root.get("hallID"), hallID);
            predicates.add(hallPredicate);
        }

        // Tìm kiếm theo giá
        if (criteria.containsKey("price")) {
            BigDecimal price = (BigDecimal) criteria.get("price");
            Predicate pricePredicate = builder.equal(root.get("totalPrice"), price);
            predicates.add(pricePredicate);
        }

        // Tìm kiếm theo ngày tổ chức
        if (criteria.containsKey("eventDate")) {
            Date eventDate = (Date) criteria.get("eventDate");
            Predicate datePredicate = builder.equal(root.get("eventDate"), eventDate);
            predicates.add(datePredicate);
        }

        if (!predicates.isEmpty()) {
            Predicate finalPredicate = builder.and(predicates.toArray(new Predicate[0]));
            query.where(finalPredicate);
        }

        List<Event> events = session.createQuery(query).getResultList();
        return events;
    }

    @Override
    public List<Event> getAllEvent() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Event");
        return q.getResultList();
    }

}
