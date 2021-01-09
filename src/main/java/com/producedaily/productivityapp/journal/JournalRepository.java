package com.producedaily.productivityapp.journal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal, Long> {

    Journal findById(long journal_id);

}
