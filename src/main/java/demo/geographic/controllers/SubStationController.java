package demo.geographic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import demo.geographic.models.SubStation;
import demo.geographic.repositories.SubStationRepository;
import demo.geographic.services.SubStationService;

@RestController
@RequestMapping("/substations")
// @AllArgsConstructor
public class SubStationController {
    // private final SubStationService subStationService;

    @Autowired
    SubStationRepository subStationRepository;

    @Autowired
    SubStationService subStationService;

    @GetMapping
    public ResponseEntity<List<SubStation>> getAllSubStations() {
        try {
            return new ResponseEntity<>(subStationService.getAllSubStations(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{id}")
	public ResponseEntity<SubStation> getSubStationById(@PathVariable String id) {
	  return new ResponseEntity<>(subStationService.getSubStationById(id), HttpStatus.OK);
	}


    @PostMapping
	public ResponseEntity<SubStation> createSubStation(@RequestBody SubStation subStationData) {
        try {
            return new ResponseEntity<>(subStationService.createSubStation(subStationData), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubStationById(@PathVariable String id) {
        try {
            subStationRepository.deleteById(id);
            return new ResponseEntity<>("Substation successfully deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
