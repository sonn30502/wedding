/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.service.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dcs.pojos.Halls;
import com.dcs.repository.HallsRepository;
import com.dcs.service.HallsService;
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
public class HallsServiceImpl implements HallsService {

    @Autowired
    private HallsRepository hallsRepository;

    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public List<Halls> getHall(Map<String, String> params) {
         return this.hallsRepository.getHall(params);
    }

    @Override
    public Halls getHallById(int hallID) {
        return this.hallsRepository.getHallById(hallID);
    }

    @Override
    public boolean addOrUpdateHall(Halls hall) {
        if (!hall.getFile().isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(hall.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                hall.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(HallsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.hallsRepository.addOrUpdateHall(hall);
    }

    @Override
    public Long countHall() {
        return this.hallsRepository.countHall();
    }

    @Override
    public boolean deleteHall(int id) {
        return this.hallsRepository.deleteHall(id);
    }

}
