package com.karngyan.newsletter.exchanges;

import com.karngyan.newsletter.dto.Subscriber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddSubscriberRequest {

    @NonNull
    private Subscriber subscriber;

}
