package com.karngyan.newsletter.repositoryservices;

import com.karngyan.newsletter.dto.Subscriber;
import org.springframework.lang.NonNull;

public interface SubscriberRepositoryService {

    @NonNull Subscriber addSubscriber(Subscriber subscriber);

}
