package com.example.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.example.domain.Tweet;
import com.example.domain.services.DomainTweetService;
import com.example.domain.services.TweetService;
import com.example.handlers.requests.CreateTweetRequest;
import com.example.infrastructure.dynamodb.DynamoDBTweetRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateTweetsHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    private TweetService tweetService;
    private HandlerUtil handlerUtil;

    public CreateTweetsHandler() {
        this.tweetService = new DomainTweetService(new DynamoDBTweetRepository());
        this.handlerUtil = new HandlerUtil();
    }

    public CreateTweetsHandler(TweetService tweetService, HandlerUtil handlerUtil) {
        this.tweetService = tweetService;
        this.handlerUtil = handlerUtil;
    }

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            CreateTweetRequest requestBody = objectMapper.readValue(event.getBody(), CreateTweetRequest.class);
            String user = handlerUtil.retrieveCognitoId(event);
            Tweet tweet = CreateTweetRequest.toTweet(requestBody, user);
            tweetService.addTweet(tweet);
        } catch (JsonProcessingException e) {

        }


        return null;
    }

}
