package com.producedaily.productivityapp.event.service;

import com.producedaily.productivityapp.event.model.Event;

import java.security.Principal;
import java.util.List;

public interface EventService {

    List<Event> findByUserId(int id);

    public void save(Event theEvent);

    public void deleteById(long event_id);

}
