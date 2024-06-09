package demo.geographic.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import demo.geographic.models.SubStation;

public interface SubStationRepository extends MongoRepository<SubStation, String> {

}
