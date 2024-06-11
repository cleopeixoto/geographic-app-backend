package demo.geographic.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.geographic.models.SubStation;
import demo.geographic.repositories.SubStationRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SubStationService {

    @Autowired
    private SubStationRepository subStationRepository;

    public List<SubStation> getAllSubStations() {
        List<SubStation> substations = this.subStationRepository.findAll();

        return substations;
    }

    public SubStation getSubStationById(String id) {
        Optional<SubStation> subStation = this.subStationRepository.findById(id);
        if (subStation.isPresent())
            return subStation.get();

        throw new NoSuchElementException("SubStation not found for this id: " + id);
    }

    public SubStation createSubStation(SubStation subStationData) throws Exception {
        // Check missing fields
        if (subStationData.getCode() == null)
            throw new Exception("Code is required.");

        // Check if Substation already exists with given code
        Boolean existSubStation = this.subStationRepository.existsByCode(subStationData.getCode());
        if (existSubStation)
            throw new Exception("There is already a Sub Station with this code: " + subStationData.getCode());

        // Create Substation
        subStationData.setCreated(LocalDateTime.now());
        return this.subStationRepository.insert(subStationData);
    }

    public SubStation updateSubStation(String id, SubStation subStationData) throws Exception {
        // Check missing fields
        if (subStationData.getCode() == null)
            throw new Exception("Code is required.");

        // Check if Substation already exists with given code
        Boolean existSubStation = this.subStationRepository.existsByCode(subStationData.getCode());
        if (existSubStation)
            throw new Exception("There is already a Sub Station with this code: " + subStationData.getCode());

        SubStation updatedStation = this.subStationRepository.findById(id).get();
        updatedStation.setCode(subStationData.getCode());
        updatedStation.setName(subStationData.getName());
        updatedStation.setLatitude(subStationData.getLatitude());
        updatedStation.setLongitude(subStationData.getLongitude());

        return this.subStationRepository.save(subStationData);
    }

    public void deleteSubStation(String id) {
        SubStation subStation = this.subStationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("SubStation not found for this id: " + id));

        this.subStationRepository.delete(subStation);
    }
}
