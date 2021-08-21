package com.example.infrastructure.dynamodb;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.IDynamoDBMapper;
import com.example.domain.Tweet;
import com.example.domain.repositories.TweetRepository;

import java.util.List;

public class DynamoDBTweetRepository implements TweetRepository {

    private IDynamoDBMapper dynamoDBMapper;

    public DynamoDBTweetRepository() {
        this.dynamoDBMapper = new DynamoDBMapper(AmazonDynamoDBClientBuilder.defaultClient());
    }

    public DynamoDBTweetRepository(IDynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    @Override
    public List<Tweet> retrieveTweets(List<String> userNames) {
        return null;
    }

    @Override
    public void addTweet(Tweet tweet) {
        dynamoDBMapper.save(tweet);
    }

    @Override
    public Tweet retrieveTweets(String userName) {
        return null;
    }
}
