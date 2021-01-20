package com.producedaily.productivityapp.event.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private EventRepository eventRepository;

    @Autowired
    private UserService userService;

    @Override
    public String findByUserName(Principal principal) throws JsonProcessingException {

        User user = userService.findByUsername(principal.getName());

        List<Event> sortedEvents = user.sortEventsByDate(user.getEvents());

        for(int i = 0; i < sortedEvents.size(); i++) {

            String eventDate = sortedEvents.get(i).getEventDate();

            sortedEvents.get(i).setEventStatus(eventDate);

        }

        String json = new ObjectMapper().writeValueAsString(sortedEvents);

        return json;

    }

    @Override
    public void saveEvent(Principal principal, Event theEvent) {

        User user = userService.findByUsername(principal.getName());

        theEvent.setUser(user);

        eventRepository.save(theEvent);

        theEvent.setEventStatus(theEvent.getEventDate());

        eventRepository.save(theEvent);

    }

    @Override
    public void deleteById(long event_id) {
        eventRepository.deleteById(event_id);
    }
}
