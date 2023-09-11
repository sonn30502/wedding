/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dcs.service;

import com.dcs.pojos.Service;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface DVService {

    List<Service> getAllService(Map<String, String> params);
    
    List<Service> getService();

    Service getServiceById(int serviceID);

    boolean addOrUpdateService(Service serivce);

    Long countService();

    boolean deleteService(int id);
}
