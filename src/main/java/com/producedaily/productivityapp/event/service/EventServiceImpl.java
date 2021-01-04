package com.producedaily.productivityapp.event.service;

import com.producedaily.productivityapp.event.model.Event;
import com.producedaily.productivityapp.event.repository.EventRepository;
import com.producedaily.productivityapp.user.model.User;
import com.producedaily.productivityapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @Override
    public List<Event> findByUserId(int id) {
        return eventService.findByUserId(id);

    }

    @Override
    public void save(Event theEvent) {
        eventService.save(theEvent);
    }

    @Override
    public void deleteById(long event_id) {
        eventService.deleteById(event_id);
    }
}
