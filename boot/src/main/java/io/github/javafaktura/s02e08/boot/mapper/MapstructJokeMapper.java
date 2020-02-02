package io.github.javafaktura.s02e08.boot.mapper;

import io.github.javafaktura.s02e08.boot.dao.JokeModel;
import io.github.javafaktura.s02e08.boot.dto.Joke;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapstructJokeMapper {

    MapstructJokeMapper INSTANCE = Mappers.getMapper(MapstructJokeMapper.class);

    @Mappings({
            @Mapping(source = "value.id", target = "externalId"),
            @Mapping(source = "value.joke", target = "value"),
            @Mapping(source = "value.categories", target = "categories")
    })
    JokeModel jokeToJokeEntity(Joke joke);

    @Mappings({
            @Mapping(source = "externalId", target = "value.id"),
            @Mapping(source = "value", target = "value.joke"),
            @Mapping(source = "categories", target = "value.categories")
    })
    Joke jokeEntityToJoke(JokeModel entity);
}
