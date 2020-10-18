package com.karngyan.newsletter.repositoryservices;

import com.karngyan.newsletter.dto.Subscriber;
import com.karngyan.newsletter.models.SubscriberEntity;
import com.karngyan.newsletter.repositories.SubscriberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Provider;
import java.util.Optional;

@Service
public class SubscriberRepositoryServiceImpl implements SubscriberRepositoryService {

    @Autowired
    private Provider<ModelMapper> modelMapperProvider;

    @Autowired
    private SubscriberRepository subscriberRepository;


    @Override
    public Subscriber addSubscriber(Subscriber subscriber) {
        assert(subscriber.getEmail() != null);

        Optional<SubscriberEntity> optionalSubscriberEntity = subscriberRepository.findByEmail(subscriber.getEmail());
        ModelMapper modelMapper = modelMapperProvider.get();

        if (optionalSubscriberEntity.isPresent()) {
            return modelMapper.map(optionalSubscriberEntity.get(), Subscriber.class);
        }

        SubscriberEntity subscriberEntity = modelMapper.map(subscriber, SubscriberEntity.class);
        subscriberRepository.save(subscriberEntity);

        return modelMapper.map(subscriberEntity, Subscriber.class);
    }
}
