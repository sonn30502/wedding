    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dcs.service;

import com.dcs.pojos.Menu;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface MenuService {

    List<Menu> getMenu(Map<String, String> params);
    
    Long countMenu();

    boolean addOrUpdateMenu(Menu menu);

    Menu getMenuById(int id);

    boolean deleteMenu(int id);
}
