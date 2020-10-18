package com.karngyan.newsletter.repositories;

import com.karngyan.newsletter.models.SubscriberEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SubscriberRepository extends MongoRepository<SubscriberEntity, String> {

    Optional<SubscriberEntity> findByEmail(String email);
}
