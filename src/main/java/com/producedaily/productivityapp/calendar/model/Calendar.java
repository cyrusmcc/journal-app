package com.producedaily.productivityapp.calendar.model;

import com.producedaily.productivityapp.security.model.User;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//@Entity
public class Calendar {

       // @Id
        //@GeneratedValue(strategy=GenerationType.IDENTITY)
        private int calendar_id;

        private LocalDate date = LocalDate.now();

        private String currentDate = date.format(DateTimeFormatter.ISO_LOCAL_DATE);

        private String currentMonth = date.getMonth().toString();

        private int dayInMonth = date.getDayOfMonth();

       //@OneToOne(fetch = FetchType.LAZY, optional = false)
       //@JoinColumn(name = "user_id", nullable = false)
       //private User user;


        public Calendar() {
        }

        public LocalDate getDate() {
                return date;
        }

        public String getCurrentDate() {
                return currentDate;
        }

        public String getCurrentMonth() {
                return currentMonth;
        }

        public int getDayInMonth() {
                return dayInMonth;
        }
}
