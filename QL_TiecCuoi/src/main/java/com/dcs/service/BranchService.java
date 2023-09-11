/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dcs.service;

import com.dcs.pojos.Branch;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface BranchService {

    List<Branch> searchBranch(Map<String, String> params);

    List<Branch> getAllBranch();

    Branch getBranchById(int branchID);

    boolean addOrUpdateBranch(Branch branch);

    boolean deleteBranch(int id);

    Long countBranch();

}
