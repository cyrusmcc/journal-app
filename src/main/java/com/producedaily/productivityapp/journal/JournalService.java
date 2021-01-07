package com.producedaily.productivityapp.journal;

import java.security.Principal;

public interface JournalService {

    Journal findJournal(Principal principal);

    String findEntryTextByDate(Principal principal);

    void saveEntry(Principal principal, JournalEntry journalEntry);
}
