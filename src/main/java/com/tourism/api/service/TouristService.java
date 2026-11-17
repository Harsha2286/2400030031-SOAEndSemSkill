package com.tourism.api.service;

import com.tourism.api.model.Tourist;
import com.tourism.api.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristService {

    @Autowired
    private TouristRepository touristRepository;

    /**
     * Retrieves all tourist records from the database.
     *
     * @return List of all tourists
     */
    public List<Tourist> getAllTourists() {
        return touristRepository.findAll();
    }
}
