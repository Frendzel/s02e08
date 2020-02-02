package io.github.javafaktura.s02e08.boot.mapper;

import io.github.javafaktura.s02e08.boot.dao.JokeModel;
import io.github.javafaktura.s02e08.boot.dto.Joke;
import io.github.javafaktura.s02e08.boot.dto.JokeValue;

import static java.util.Arrays.asList;

public class ManualJokeMapper {
    public static JokeModel map(Joke joke) {
        return JokeModel.builder()
                .value(joke.getValue().getJoke())
                .categories(asList(joke.getValue().getCategories()))
                .externalId(joke.getValue().getId())
                .build();
    }

    public static Joke map(JokeModel entity) {
        return Joke.builder()
                .value(JokeValue.builder()
                        .id(entity.getExternalId())
                        .joke(entity.getValue())
                        .categories((String[]) entity.getCategories().toArray())
                        .build())
                .build();
    }
}
