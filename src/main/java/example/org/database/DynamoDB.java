package example.org.database;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public class DynamoDB {
    static public AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
}
