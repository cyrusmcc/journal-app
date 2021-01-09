package com.producedaily.productivityapp.journal;

import java.security.Principal;

public interface JournalService {

    Journal findJournal(Principal principal);

    JournalEntry findEntryById(long id);

    JournalEntry findEntryByDate(Principal principal);

    void updateEntry(JournalEntry journalEntry);
}
