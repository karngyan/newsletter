package com.karngyan.newsletter.exchanges;

import com.karngyan.newsletter.dto.Subscriber;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddSubscriberResponse {

    private Subscriber subscriber;
}
