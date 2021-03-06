package com.example.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "user")
public class Tweet {

    @DynamoDBHashKey(attributeName = "user")
    private String user;

    @DynamoDBAttribute(attributeName = "dateCreated")
    private long dateCreated;

    @DynamoDBAttribute(attributeName = "message")
    private String message;
}
