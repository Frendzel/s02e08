package io.github.javafaktura.s02e08.boot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

//{
//        "type": "success",
//        "value": {
//        "id": 298,
//        "joke": "MacGyver immediately tried to make a bomb out of some Q-Tips and Gatorade, but Chuck Norris roundhouse-kicked him in the solar plexus. MacGyver promptly threw up his own heart.",
//        "categories": []
//        }
//        }
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NotNull
public class Joke {
    String type;
    @NotNull
    JokeValue value;
}
