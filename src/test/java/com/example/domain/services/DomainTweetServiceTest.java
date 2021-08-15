package com.example.domain.services;

import com.example.domain.Tweet;
import com.example.domain.repositories.TweetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DomainTweetServiceTest {

    private TweetRepository mockTweetRepository;
    private TweetService tweetService;

    @BeforeEach
    void setup() {
        mockTweetRepository = mock(TweetRepository.class);
        tweetService = new DomainTweetService(mockTweetRepository);
    }

    @Test
    void shouldAddTweet() {
        Tweet mockTweet = mock(Tweet.class);
        tweetService.addTweet(mockTweet);
        verify(mockTweetRepository).addTweet(mockTweet);
    }
}
