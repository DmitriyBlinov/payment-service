package utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DataSourceFactory {
    private final MongoDatabase database;
    private final MongoCollection<Document> collection;
    private final MongoClient client;
    private final String host = "localhost";
    private final String port = "27017";

    public DataSourceFactory() {
        this.client = new MongoClient(new MongoClientURI("mongodb://" + host + ":" + port + "/?appName=PaymentService"));
        this.database = client.getDatabase("clients");
        this.collection = database.getCollection("payments");
    }

    public MongoCollection<Document> getCollection() {
        return collection;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public MongoClient getClient() {
        return client;
    }
}