/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.formatters;

import com.dcs.pojos.Branch;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author ASUS
 */
public class BranchFormatter implements Formatter<Branch> {

    @Override
    public String print(Branch branch, Locale locale) {
        return String.valueOf(branch.getBranchID());
    }

    @Override
    public Branch parse(String branchID, Locale locale) throws ParseException {
        int id = Integer.parseInt(branchID);
        return new Branch(id);
    }

}
