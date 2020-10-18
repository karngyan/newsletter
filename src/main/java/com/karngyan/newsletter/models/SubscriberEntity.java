package com.karngyan.newsletter.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Document(collection = "subscribers")
@NoArgsConstructor
public class SubscriberEntity {

    @Version
    private Long version;

    @Id
    private String id;

    @NotNull
    @Indexed(unique = true)
    @Email
    private String email;

    @CreatedDate
    private Date created;

}
