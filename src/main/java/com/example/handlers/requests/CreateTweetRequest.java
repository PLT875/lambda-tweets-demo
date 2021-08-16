package com.example.handlers.requests;

import com.example.domain.Tweet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTweetRequest {

    private String message;

    public static Tweet toTweet(CreateTweetRequest request) {
        long dateCreated = LocalDateTime
                .now(ZoneOffset.UTC)
                .atZone(ZoneOffset.UTC)
                .toEpochSecond();

        return Tweet.builder()
                .id(UUID.randomUUID().toString())
                .message(request.message)
                .dateCreated(dateCreated)
                .build();
    }
}
