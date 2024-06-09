package com.java.geographic.repositories;

// import org.bson.types.ObjectId;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.java.geographic.models.SubStation;

public interface SubStationRepository extends MongoRepository<SubStation, String> {

    public Optional<SubStation> findById(String id);

    public void deleteById(String id);
}
