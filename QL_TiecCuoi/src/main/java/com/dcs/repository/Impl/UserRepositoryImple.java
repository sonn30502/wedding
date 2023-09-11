/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.repository.Impl;

import com.dcs.pojos.User;
import com.dcs.repository.UserRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ASUS
 */
@Repository
@Transactional
public class UserRepositoryImple implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Override
    public User addUser(User user) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        s.save(user);
        return user;
    }

//    @Override
//    public List<User> getUsers(String username) {
//        Session s = this.sessionFactory.getObject().getCurrentSession();
//        CriteriaBuilder builder = s.getCriteriaBuilder();
//        CriteriaQuery<User> query = builder.createQuery(User.class);
//        Root root = query.from(User.class);
//        query = query.select(root);
//
//        if (!username.isEmpty()) {
//            Predicate p = builder.equal(root.get("username").as(String.class), username.trim());
//            query = query.where(p);
//        }
//
//        Query q = s.createQuery(query);
//        return q.getResultList();
//    }
    @Override
    public User getUserByUsername(String username) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM User WHERE username=:un");
        q.setParameter("un", username);
        return (User) q.getSingleResult();
    }

    @Override
    public boolean authUser(String username, String password) {
        User user = this.getUserByUsername(username);

        return this.passEncoder.matches(password, user.getPassword());
    }


}
