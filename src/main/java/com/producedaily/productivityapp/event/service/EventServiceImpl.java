package com.producedaily.productivityapp.event.service;

import com.producedaily.productivityapp.event.model.Event;
import com.producedaily.productivityapp.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> findByUserId(int id) {

        return eventRepository.findByUserId(id);

    }

    @Override
    public void save(Event theEvent) {
        eventRepository.save(theEvent);
    }

    @Override
    public void deleteById(long event_id) {
        eventRepository.deleteById(event_id);
    }
}
