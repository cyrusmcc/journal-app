package com.producedaily.productivityapp.journal.service;

import com.producedaily.productivityapp.journal.model.Journal;
import com.producedaily.productivityapp.journal.model.JournalEntry;

import java.security.Principal;

public interface JournalService {

    Journal findJournal(Principal principal);

    JournalEntry findEntryById(long id);

    JournalEntry findEntryByDate(Principal principal);

    JournalEntry findEntryByJournalAndDate(Journal journal, String userDate);

    void saveEntry(JournalEntry journalEntry);
}
