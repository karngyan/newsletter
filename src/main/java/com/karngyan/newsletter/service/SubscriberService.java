package com.karngyan.newsletter.service;

import com.karngyan.newsletter.dto.Subscriber;
import com.karngyan.newsletter.exchanges.AddSubscriberResponse;

public interface SubscriberService {

    AddSubscriberResponse addSubscriber(Subscriber subscriber);

}
