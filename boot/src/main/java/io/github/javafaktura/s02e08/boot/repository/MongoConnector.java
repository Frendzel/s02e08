package io.github.javafaktura.s02e08.boot.repository;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.github.javafaktura.s02e08.boot.dto.Joke;
import io.github.javafaktura.s02e08.boot.exception.JokeNotFoundException;
import io.github.javafaktura.s02e08.boot.exception.ValidationException;
import io.github.javafaktura.s02e08.boot.monitoring.CalculateInvocationTime;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class MongoConnector {
    private static final String DB_NAME = "javafaktura";
    private static final String COLLECTION_NAME = "jokes";

    private final MongoClient mongoClient;
    private Gson gson = new Gson();

    public MongoConnector(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    @PostConstruct
    public void check() {
        MongoCollection<Document> jokes = getJokesCollection();
        log.debug("Successfully connected to the: {}, collection: {} with size: {}",
                DB_NAME,
                COLLECTION_NAME,
                jokes.countDocuments());
    }

    @CalculateInvocationTime
    public void saveJoke(Joke joke) {
        MongoCollection<Document> jokes = getJokesCollection();
        Gson gson = new Gson();
        try {
            jokes.insertOne(Document.parse(gson.toJson(joke)));
        } catch (Exception e) {
            throw new ValidationException("Wrong joke format");
        }
        log.debug("Successfully inserted document to the database");
    }


    public Joke findJoke(Joke joke) {
        if (joke == null) {
            throw new ValidationException("Wrong joke format");
        }
        MongoCollection<Document> jokes = getJokesCollection();
        return findJoke(joke, jokes);
    }

    private Joke findJoke(Joke joke, MongoCollection<Document> jokes) {
        //byId
        for (Document document : jokes.find(new Document("value.id", joke.getValue().getId()))) {
            return gson.fromJson(document.toJson(), Joke.class);
        }

        //byJoke
        for (Document document : jokes.find(new Document("value.joke", joke.getValue().getJoke()))) {
            return gson.fromJson(document.toJson(), Joke.class);
        }

        //byCategory
        for (Document document : jokes.find(new Document("value.categories", joke.getValue().getCategories()))) {
            return gson.fromJson(document.toJson(), Joke.class);
        }
        throw new JokeNotFoundException("Cannot find joke with params: " + joke.toString());
    }

    private MongoCollection<Document> getJokesCollection() {
        MongoDatabase db = mongoClient.getDatabase(DB_NAME);
        return db.getCollection(COLLECTION_NAME);
    }
}
