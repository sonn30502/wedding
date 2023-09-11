/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.repository.Impl;

import com.dcs.pojos.Menu;
import com.dcs.repository.MenuRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
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
public class MenuRepositoryImpl implements MenuRepository {

    @Autowired
    private LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;

    @Autowired
    private SimpleDateFormat simpleDateFormat;

    @Override
    public List<Menu> getMenu(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Menu> q = b.createQuery(Menu.class);
        Root root = q.from(Menu.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("menuName"), String.format("%%%s%%", kw)));
            }
            
            q.where(b.and(predicates.toArray(new Predicate[0])));
        }

        q.orderBy(b.asc(root.get("menuID")));

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
    public Long countMenu() {

        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT Count(*) FROM Menu");

        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public boolean addOrUpdateMenu(Menu menu) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            menu.setCreatedDate(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
            if (menu.getMenuID() == null) {
                s.save(menu);
            } else {
                s.update(menu);
            }
            return true;
        } catch (ParseException ex) {
            Logger.getLogger(MenuRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Menu getMenuById(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        return session.get(Menu.class, id);
    }

    @Override
    public boolean deleteMenu(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Query q = session.createQuery("DELETE FROM Menu WHERE menuID = :id");
        q.setParameter("id", id);
        int result = q.executeUpdate();
        return result > 0;
    }
}
