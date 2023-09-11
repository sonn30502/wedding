/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dcs.service;

import com.dcs.pojos.Event;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public interface EventService {

    void addOrUpdateEvent(Event event);

    Event getEventById(int eventID);

    void deleteEvent(Event event);

    List<Event> searchEventsByCriteria(Map<String, Object> criteria);

    List<Event> getAllEvent();
}
