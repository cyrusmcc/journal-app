package com.producedaily.productivityapp.event.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.producedaily.productivityapp.event.model.Event;

import java.security.Principal;
import java.util.List;

public interface EventService {

    String findByUserId(int id) throws JsonProcessingException;

    public void saveEvent(Principal principal, Event theEvent);

    public void deleteById(long event_id);

}
