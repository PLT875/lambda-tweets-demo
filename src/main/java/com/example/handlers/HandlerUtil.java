package com.example.handlers;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;

public class HandlerUtil {
    public String retrieveCognitoId(APIGatewayProxyRequestEvent event) {
        return event.getRequestContext().getIdentity().getCognitoIdentityId();
    }

}
