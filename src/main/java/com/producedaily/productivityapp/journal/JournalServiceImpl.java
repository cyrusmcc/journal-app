package com.producedaily.productivityapp.journal;

import com.producedaily.productivityapp.user.model.User;
import com.producedaily.productivityapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDate;

@Service
public class JournalServiceImpl implements JournalService {

    @Autowired
    private UserService userService;

    @Autowired
    JournalEntryRepository jEntryRepo;

    @Override
    public Journal findJournal(Principal principal) {
        return userService.findByUsername(principal.getName()).getJournal();
    }



    @Override
    public JournalEntry findEntryTextByDate(Principal principal) {

        User user = userService.findByUsername(principal.getName());

        String date = user.getLocalDate();

        JournalEntry journalEntry = jEntryRepo.
                findJournalEntryByJournalAndEntryDate(user.getJournal(), date);

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

       /*
        Journal journal =
                userService.findByUsername(principal.getName()).getJournal();

        User user = userService.findByUsername(principal.getName());

        String userDate = user.getLocalDate().toString();

        JournalEntry entry =
                jEntryRepo.findJournalEntryByJournalAndEntryDate(journal,userDate);

        entry.setText(text);

        jEntryRepo.save(entry);

        */
    }
}
