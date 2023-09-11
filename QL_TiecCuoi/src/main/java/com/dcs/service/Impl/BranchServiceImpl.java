/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.service.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dcs.pojos.Branch;
import com.dcs.repository.BranchRepository;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dcs.service.BranchService;

/**
 *
 * @author ASUS
 */
@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Branch> getAllBranch() {
        return branchRepository.getAllBranch();
    }

    @Override
    public Branch getBranchById(int branchID) {
        return branchRepository.getBranchById(branchID);
    }

    @Override
    public boolean addOrUpdateBranch(Branch branch) {
        if (!branch.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(branch.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                branch.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(BranchServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.branchRepository.addOrUpdateBranch(branch);
    }

    @Override
    public boolean deleteBranch(int id) {
        return this.branchRepository.deleteBranch(id);
    }

    @Override
    public Long countBranch() {
        return this.branchRepository.countBranch();
    }

    @Override
    public List<Branch> searchBranch(Map<String, String> params) {
        return this.branchRepository.searchBranch(params);
    }

}
