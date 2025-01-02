package br.com.spotify_integration.controller;

import br.com.spotify_integration.client.AlbumSpotifyClient;
import br.com.spotify_integration.client.AuthSpotifyClient;
import br.com.spotify_integration.domain.Album;
import br.com.spotify_integration.domain.AlbumResponse;
import br.com.spotify_integration.domain.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spotify/api")
@AllArgsConstructor
public class AlbumController {

    private final AuthSpotifyClient authSpotifyClient;
    private final AlbumSpotifyClient albumSpotifyClient;

    @GetMapping("/albums")
    public ResponseEntity<List<Album>> getAlbums(){
        LoginRequest request = LoginRequest.builder()
                .clientId("61ea62c6f2084533a61f47d233331a08")
                .clientSecret("016965e61cef471a8a8b61c457eae7b8")
                .grantType("client_credentials")
                .build();

        String accessToken = authSpotifyClient.login(request).getAccessToken();

        AlbumResponse response = albumSpotifyClient.getReleases("Bearer " + accessToken);

        return ResponseEntity.ok(response.getAlbums().getItems());
    }
}
