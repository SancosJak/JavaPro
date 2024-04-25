package de.ait.worddemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WordDTO {

    @JsonProperty("value")
    private String value;

}

