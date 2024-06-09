package com.java.geographic.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.geographic.models.SubStation;
import com.java.geographic.repositories.SubStationRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SubStationService {
    
    @Autowired
	private SubStationRepository subStationRepository;

    public List<SubStation> getAllSubStations() {
        return subStationRepository.findAll();
    }

    public SubStation getSubStationById(String id) {
        Optional<SubStation> subStation = subStationRepository.findById(id);
        if (subStation.isPresent()) {
            return subStation.get();
        } else {
            throw new NoSuchElementException("SubStation not found for this id: " + id);
        }
    }

	public SubStation createSubStation(SubStation subStationData) {
        subStationData.setCreated(LocalDateTime.now());
        return subStationRepository.save(subStationData);
	}

    public void deleteSubStation(String id) {
        SubStation subStation = subStationRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("SubStation not found for this id: " + id));

        subStationRepository.delete(subStation);
    }
}
