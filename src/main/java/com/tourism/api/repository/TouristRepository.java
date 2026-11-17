package com.tourism.api.repository;

import com.tourism.api.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TouristRepository extends JpaRepository<Tourist, Long> {
    // JpaRepository provides findAll(), save(), deleteById(), etc. out of the box
}
