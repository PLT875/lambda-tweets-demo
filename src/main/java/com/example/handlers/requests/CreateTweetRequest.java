package com.example.handlers.requests;

import com.example.domain.Tweet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateTweetRequest {

    private String message;

    public static Tweet toTweet(CreateTweetRequest request, String user) {
        long dateCreated = LocalDateTime
                .now(ZoneOffset.UTC)
                .atZone(ZoneOffset.UTC)
                .toEpochSecond();

        return Tweet.builder()
                .user(user)
                .message(request.message)
                .dateCreated(dateCreated)
                .build();
    }
}
