package io.github.javafaktura.s02e08.boot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * //{
 * //        "type": "success",
 * //        "value": {
 * //        "id": 298,
 * //        "joke": "MacGyver immediately tried to make a bomb out of some Q-Tips and Gatorade, but Chuck Norris roundhouse-kicked him in the solar plexus. MacGyver promptly threw up his own heart.",
 * //        "categories": []
 * //        }
 * //        }
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JokeValue {
    Integer id;
    String joke;
    String[] categories;
}
