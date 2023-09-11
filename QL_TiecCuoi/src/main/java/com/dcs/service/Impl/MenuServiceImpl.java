/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.service.Impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dcs.pojos.Menu;
import com.dcs.repository.MenuRepository;
import com.dcs.service.MenuService;
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
public class MenuServiceImpl implements MenuService{
    
    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Menu> getMenu(Map<String, String> params) {
        return this.menuRepository.getMenu(params);
    }

    @Override
    public boolean addOrUpdateMenu(Menu menu) {
        if(!menu.getFile().isEmpty()){
            try {
                Map res = this.cloudinary.uploader().upload(menu.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                menu.setImage(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(MenuServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.menuRepository.addOrUpdateMenu(menu);
    }

    @Override
    public Menu getMenuById(int id) {
        return this.menuRepository.getMenuById(id);
    }

    @Override
    public boolean deleteMenu(int id) {
        return this.menuRepository.deleteMenu(id);
    }

    @Override
    public Long countMenu() {
        return this.menuRepository.countMenu();
    }
}
