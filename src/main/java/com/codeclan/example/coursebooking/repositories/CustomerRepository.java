package com.codeclan.example.coursebooking.repositories;

import com.codeclan.example.coursebooking.models.Course;
import com.codeclan.example.coursebooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookingsCourseId(Long id);

    List<Customer> findByTownAndBookingsCourseIdAllIgnoreCase(String town, Long id);

    List<Customer> findByTownAndBookingsCourseIdAndAgeGreaterThanAllIgnoreCase(String town, Long id, int age);

    List<Customer> findByTownAndBookingsCourseIdAndAgeGreaterThanAndBookingsCourseRatingGreaterThanEqualAllIgnoreCase(String town, Long id, int age, int rating);
}
