package com.karngyan.newsletter.controller;

import com.karngyan.newsletter.exchanges.AddSubscriberRequest;
import com.karngyan.newsletter.exchanges.AddSubscriberResponse;
import com.karngyan.newsletter.service.SubscriberService;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping(SubscriberController.NEWSLETTER_API_ENDPOINT)
public class SubscriberController {

    public static final String NEWSLETTER_API_ENDPOINT = "/api/v1";
    public static final String SUBSCRIBER_API = "/subscriber";

    @Autowired
    private SubscriberService subscriberService;

    private final Bucket bucket;

    public SubscriberController() {
        Bandwidth limit = Bandwidth.classic(10, Refill.greedy(10, Duration.ofHours(1)));
        this.bucket = Bucket4j.builder()
                .addLimit(limit)
                .build();
    }

    @PostMapping(SUBSCRIBER_API)
    public ResponseEntity<AddSubscriberResponse> addSubscriber(
            @Valid @RequestBody AddSubscriberRequest addSubscriberRequest
            ) {

        if (bucket.tryConsume(1)) {
            try {
                log.info(addSubscriberRequest.getSubscriber().toString());
                AddSubscriberResponse addSubscriberResponse = subscriberService
                        .addSubscriber(addSubscriberRequest.getSubscriber());
                return ResponseEntity.ok().body(addSubscriberResponse);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        }
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();

    }
}
