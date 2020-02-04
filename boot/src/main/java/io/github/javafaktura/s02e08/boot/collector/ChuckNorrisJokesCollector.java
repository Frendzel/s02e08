package io.github.javafaktura.s02e08.boot.collector;

import io.github.javafaktura.s02e08.boot.dto.Joke;
import io.github.javafaktura.s02e08.boot.repository.MongoConnector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@Service
@Slf4j
//TODO add scheduler
public class ChuckNorrisJokesCollector {
    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private MongoConnector mongoConnector;

    @PostConstruct
    public void saveJokeFromChuckApi() {
        ResponseEntity<Joke> entity = restTemplate.getForEntity("http://api.icndb.com/jokes/random", Joke.class);
        Joke joke = entity.getBody();
        mongoConnector.saveJoke(joke);
        log.info("I've saved this awesome joke: {}", joke);
    }
}
