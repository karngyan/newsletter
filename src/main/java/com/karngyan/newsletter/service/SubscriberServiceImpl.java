package com.karngyan.newsletter.service;

import com.karngyan.newsletter.dto.Subscriber;
import com.karngyan.newsletter.exchanges.AddSubscriberResponse;
import com.karngyan.newsletter.repositoryservices.SubscriberRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    private SubscriberRepositoryService subscriberRepositoryService;

    @Override
    public AddSubscriberResponse addSubscriber(Subscriber subscriber) {

        AddSubscriberResponse addSubscriberResponse = new AddSubscriberResponse();
        subscriber = subscriberRepositoryService.addSubscriber(subscriber);
        addSubscriberResponse.setSubscriber(subscriber);

        return addSubscriberResponse;
    }
}
