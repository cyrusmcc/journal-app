package com.producedaily.productivityapp.journal;

import java.security.Principal;

public interface JournalService {

    Journal findJournal(Principal principal);

    JournalEntry findEntryTextByDate(Principal principal);

    void updateEntry(JournalEntry journalEntry);
}
