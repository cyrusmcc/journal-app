package com.producedaily.productivityapp.user.repository;

import com.producedaily.productivityapp.journal.JournalEntry;
import com.producedaily.productivityapp.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

     User findByUsername(String username);
}
