package demo.geographic.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.geographic.models.Network;
import demo.geographic.repositories.NetworkRespository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NetworkService {

    @Autowired
	private NetworkRespository networkRepository;

    @Autowired
    public SubStationService subStationService;

    public List<Network> getAllNetworks() {
        return this.networkRepository.findAll();
    }

    public Network getNetworkById(String id) {
        Optional<Network> network = this.networkRepository.findById(id);
        if (network.isPresent()) return network.get();

        throw new NoSuchElementException("Network not found for this id: " + id);
    }

	public Network createNetwork(Network networkData) throws Exception{
        // Check missing fields
        if (networkData.getSubStationId() == null) throw new Exception("Substation ID is required.");
        if (networkData.getCode() == null) throw new Exception("Code is required");

        try {
            this.subStationService.getSubStationById(networkData.getSubStationId());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        // Check if Network already exists with given code
        Boolean existNetwork = this.networkRepository.existsByCode(networkData.getCode());
        if (existNetwork) throw new Exception("There is already an MT Network with this code: " + networkData.getCode());

        // Create the network
        networkData.setCreated(LocalDateTime.now());
        return this.networkRepository.save(networkData);
	}

    public void deleteNetwork(String id) {
        Network network = this.networkRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Network not found for this id: " + id));

        this.networkRepository.delete(network);
    }
}
