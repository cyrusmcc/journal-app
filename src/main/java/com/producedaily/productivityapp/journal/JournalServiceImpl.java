package com.producedaily.productivityapp.journal;

import com.producedaily.productivityapp.user.model.User;
import com.producedaily.productivityapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class JournalServiceImpl implements JournalService {

    @Autowired
    private UserService userService;

    @Autowired
    JournalEntryRepository jEntryRepo;

    @Autowired
    JournalRepository journalRepository;

    @Override
    public Journal findJournal(Principal principal) {
        return userService.findByUsername(principal.getName()).getJournal();
    }
    
    public JournalEntry findEntryById(long id) {

        JournalEntry entry = jEntryRepo.findJournalEntryById(id);

        return entry;
    }

    @Override
    public JournalEntry findEntryByDate(Principal principal) {

        User user = userService.findByUsername(principal.getName());

        String date = user.getLocalDate();

        long journalId = user.getJournal().getId();

        Journal userJournal = journalRepository.findById(journalId);

        JournalEntry journalEntry = jEntryRepo.
               findJournalEntryByJournalAndEntryDate(userJournal, date);


        // check if entry already exists with user's date, if not create new entry
        if(journalEntry == null) {

            JournalEntry newEntry = new JournalEntry();
            newEntry.setJournal(user.getJournal());
            newEntry.setEntryDate(LocalDate.now().toString());

            jEntryRepo.save(newEntry);
            return newEntry;
        } else {
            return journalEntry;
        }
    }

    @Override
    public void updateEntry(JournalEntry journalEntry) {

        jEntryRepo.save(journalEntry);

    }
}
