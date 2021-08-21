package com.example.handlers;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.example.domain.Tweet;
import com.example.domain.services.TweetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CreateTweetsHandlerTest {

    private CreateTweetsHandler createTweetsHandler;

    @Mock
    private TweetService mockTweetService;

    @Mock
    private HandlerUtil mockHandlerUtil;

    @Mock
    private APIGatewayProxyRequestEvent mockRequestEvent;

    @Mock
    private Context context;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        createTweetsHandler = new CreateTweetsHandler(mockTweetService, mockHandlerUtil);
    }

    @Test
    public void shouldReturn204WhenSuccessfullyAddTweet() {
        when(mockRequestEvent.getBody()).thenReturn("{\"message\":\"some message\"}");
        when(mockHandlerUtil.retrieveCognitoId(mockRequestEvent)).thenReturn("user0");
        APIGatewayProxyResponseEvent response = createTweetsHandler.handleRequest(mockRequestEvent, context);
        verify(mockTweetService).addTweet(any(Tweet.class));
    }

}
