package br.com.spotify_integration.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import feign.form.FormProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album {
    private String id;
    private String name;
    @JsonProperty("release_date")
    private String releaseDate;
}
