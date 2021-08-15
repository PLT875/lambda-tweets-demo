package com.example.domain.services;

import com.example.domain.Tweet;
import com.example.domain.repositories.TweetRepository;

public class DomainTweetService implements TweetService {

    private TweetRepository tweetRepository;

    public DomainTweetService(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Override
    public void addTweet(Tweet tweet) {
        tweetRepository.addTweet(tweet);
    }
}
