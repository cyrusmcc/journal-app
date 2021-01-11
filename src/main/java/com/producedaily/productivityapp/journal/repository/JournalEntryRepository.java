package com.producedaily.productivityapp.journal.repository;

import com.producedaily.productivityapp.journal.model.Journal;
import com.producedaily.productivityapp.journal.model.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepository extends JpaRepository<JournalEntry, Long> {

    JournalEntry findJournalEntryById(long id);

    JournalEntry findJournalEntryByJournalAndEntryDate(Journal journal, String date);

}
