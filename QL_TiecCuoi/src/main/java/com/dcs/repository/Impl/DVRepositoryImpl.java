/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.repository.Impl;

import com.dcs.pojos.Service;
import com.dcs.repository.DVRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class DVRepositoryImpl implements DVRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Override
    public List<Service> getAllService(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Service> q = b.createQuery(Service.class);
        Root root = q.from(Service.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("serviceName"), String.format("%%%s%%", kw)));
            }

//            String fromPrice = params.get("fromPrice");
//            if (fromPrice != null && !fromPrice.isEmpty()) {
//                Predicate priceCondition = b.or(
//                        b.greaterThanOrEqualTo(root.get("priceMorning"), new BigDecimal(fromPrice)),
//                        b.greaterThanOrEqualTo(root.get("priceAfternoon"), new BigDecimal(fromPrice)),
//                        b.greaterThanOrEqualTo(root.get("priceEvening"), new BigDecimal(fromPrice)),
//                        b.greaterThanOrEqualTo(root.get("priceWeekend"), new BigDecimal(fromPrice))
//                );
//                predicates.add(priceCondition);
//            }
//
//            String toPrice = params.get("toPrice");
//            if (toPrice != null && !toPrice.isEmpty()) {
//                Predicate priceCondition = b.or(
//                        b.lessThanOrEqualTo(root.get("priceMorning"), new BigDecimal(toPrice)),
//                        b.lessThanOrEqualTo(root.get("priceAfternoon"), new BigDecimal(toPrice)),
//                        b.lessThanOrEqualTo(root.get("priceEvening"), new BigDecimal(toPrice)),
//                        b.lessThanOrEqualTo(root.get("priceWeekend"), new BigDecimal(toPrice))
//                );
//                predicates.add(priceCondition);
//            }
//
//            String branchId = params.get("branchID");
//            if (branchId != null && !branchId.isEmpty()) {
//                predicates.add(b.equal(root.get("branchID"), Integer.parseInt(branchId)));
//            }
            q.where(b.and(predicates.toArray(new Predicate[0])));
        }

        q.orderBy(b.desc(root.get("serviceID")));

        Query query = session.createQuery(q);

        if (params != null) {
            String page = params.get("page");
            if (page != null && !page.isEmpty()) {
                int p = Integer.parseInt(page);
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));

                query.setMaxResults(pageSize);
                query.setFirstResult((p - 1) * pageSize);
            }
        }

        return query.getResultList();
    }

    @Override
    public List<Service> getService() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Service");
        return q.getResultList();
    }

    @Override
    public Service getServiceById(int serviceID) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Service.class, serviceID);
    }

    @Override
    public boolean addOrUpdateService(Service serivce) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (serivce.getServiceID() == null) {
                s.save(serivce);
            } else {
                s.update(serivce);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Long countService() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT Count(*) FROM Service");

        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public boolean deleteService(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Query q = session.createQuery("DELETE FROM Service WHERE serviceID = :id");
        q.setParameter("id", id);
        int result = q.executeUpdate();
        return result > 0;
    }

}
