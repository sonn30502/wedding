/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.service.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dcs.repository.DVRepository;
import com.dcs.service.DVService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class DVServiceImpl implements DVService {

    @Autowired
    private DVRepository dvRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<com.dcs.pojos.Service> getAllService(Map<String, String> params) {
        return this.dvRepository.getAllService(params);
    }

    @Override
    public com.dcs.pojos.Service getServiceById(int serviceID) {
        return this.dvRepository.getServiceById(serviceID);
    }

    @Override
    public boolean addOrUpdateService(com.dcs.pojos.Service serivce) {
        if (!serivce.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(serivce.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                serivce.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(DVServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return this.dvRepository.addOrUpdateService(serivce);
    }

    @Override
    public Long countService() {
        return this.dvRepository.countService();
    }

    @Override
    public boolean deleteService(int id) {
        return this.dvRepository.deleteService(id);
    }

    @Override
    public List<com.dcs.pojos.Service> getService() {
        return this.dvRepository.getService();
    }

}
