package com.producedaily.productivityapp.journal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalEntryRepository extends JpaRepository<JournalEntry, Long> {

    JournalEntry findJournalEntryById(long id);

    JournalEntry findJournalEntryByJournalAndEntryDate(Journal journal, String date);

}
