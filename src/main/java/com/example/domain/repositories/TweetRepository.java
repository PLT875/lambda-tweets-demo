package com.example.domain.repositories;

import com.example.domain.Tweet;

import java.util.List;

public interface TweetRepository {
    List<Tweet> retrieveTweets(List<String> userNames);
    void addTweet(Tweet tweet);
    Tweet retrieveTweets(String userName);
}
