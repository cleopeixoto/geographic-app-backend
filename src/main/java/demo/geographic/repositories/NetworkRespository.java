package demo.geographic.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import demo.geographic.models.Network;

public interface NetworkRespository extends MongoRepository<Network, String> {

    boolean existsByCode(String code);
}
