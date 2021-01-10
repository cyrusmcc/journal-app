package com.producedaily.productivityapp.journal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepository extends JpaRepository<JournalEntry, Long> {

    JournalEntry findJournalEntryById(long id);

    JournalEntry findJournalEntryByJournalAndEntryDate(Journal journal, String date);

}
