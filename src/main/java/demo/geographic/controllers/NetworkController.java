package demo.geographic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.geographic.models.Network;
import demo.geographic.services.NetworkService;

@CrossOrigin
@RestController
@RequestMapping("/networks")
public class NetworkController {

    @Autowired
    NetworkService networkService;

    @GetMapping
    public ResponseEntity<List<Network>> getAllNetworks() {
        try {
            return new ResponseEntity<>(networkService.getAllNetworks(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Network> getNetworkById(@PathVariable String id) {
        return new ResponseEntity<>(networkService.getNetworkById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createNetwork(@RequestBody Network networkData) {
        try {
            return new ResponseEntity<>(networkService.createNetwork(networkData), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNetworkById(@PathVariable String id) {
        try {
            networkService.deleteNetwork(id);
            return new ResponseEntity<>("Network successfully deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
