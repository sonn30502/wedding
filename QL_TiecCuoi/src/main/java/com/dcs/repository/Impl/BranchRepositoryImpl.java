/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.repository.Impl;

import com.dcs.pojos.Branch;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.dcs.repository.BranchRepository;
import java.util.ArrayList;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.core.env.Environment;

/**
 *
 * @author ASUS
 */
@Repository
@Transactional
@PropertySource("classpath:configs.properties")
public class BranchRepositoryImpl implements BranchRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private Environment env;

    @Override
    public List<Branch> getAllBranch() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Branch");
        return q.getResultList();
    }

    @Override
    public Branch getBranchById(int branchID) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Branch.class, branchID);
    }

    @Override
    public boolean addOrUpdateBranch(Branch branch) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (branch.getBranchID() == null) {
                s.save(branch);
            } else {
                s.update(branch);
            }

            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteBranch(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Query q = session.createQuery("DELETE FROM Branch WHERE branchID = :id");
        q.setParameter("id", id);
        int result = q.executeUpdate();
        return result > 0;
    }

    @Override
    public Long countBranch() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT Count(*) FROM Branch");

        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public List<Branch> searchBranch(Map<String, String> params) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Branch> q = b.createQuery(Branch.class);
        Root root = q.from(Branch.class);
        q.select(root);
        if (params != null) {
            // Tạo danh sách các Predicate để thêm điều kiện tìm kiếm
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("branchName"), String.format("%%%s%%", kw)));
            }

            // Kết hợp các điều kiện với AND
            q.where(b.and(predicates.toArray(new Predicate[0])));

        }
        q.orderBy(b.asc(root.get("branchID")));
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

}
