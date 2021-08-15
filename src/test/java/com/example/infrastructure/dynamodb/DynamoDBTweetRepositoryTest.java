package com.example.infrastructure.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.IDynamoDBMapper;
import com.example.domain.Tweet;
import com.example.domain.repositories.TweetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DynamoDBTweetRepositoryTest {

    private IDynamoDBMapper mockDynamoDBMapper;
    private TweetRepository tweetRepository;

    @BeforeEach
    void setup() {
        mockDynamoDBMapper = mock(IDynamoDBMapper.class);
        tweetRepository = new DynamoDBTweetRepository(mockDynamoDBMapper);
    }

    @Test
    void shouldAddTweet() {
        Tweet mockTweet = mock(Tweet.class);
        tweetRepository.addTweet(mockTweet);
        verify(mockDynamoDBMapper).save(mockTweet);
    }

}
