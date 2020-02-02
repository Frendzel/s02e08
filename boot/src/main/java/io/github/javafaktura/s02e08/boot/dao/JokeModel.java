package io.github.javafaktura.s02e08.boot.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JokeModel {
    Integer id;
    Integer externalId;
    String value;
    List<String> categories = new ArrayList<>();
}
