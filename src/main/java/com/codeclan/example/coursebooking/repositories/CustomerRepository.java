package com.codeclan.example.coursebooking.repositories;

import com.codeclan.example.coursebooking.models.Course;
import com.codeclan.example.coursebooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookingsCourseName(String courseName);

    List<Customer> findByTownAndBookingsCourseName(String town, String courseName);
}
