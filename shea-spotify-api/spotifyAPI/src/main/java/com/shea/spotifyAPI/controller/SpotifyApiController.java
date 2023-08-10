package com.shea.spotifyAPI.controller;

import com.wrapper.spotify.model_objects.specification.*;
import com.wrapper.spotify.requests.data.personalization.simplified.GetUsersTopArtistsRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.shea.spotifyAPI.controller.AuthController.spotifyApi;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 4800)
public class SpotifyApiController {

    @GetMapping(value = "/user-top-artists")
    public Artist[] getUserTopArtists() {

        GetUsersTopArtistsRequest getUsersTopArtistsRequest = spotifyApi.getUsersTopArtists()
                .time_range("medium_term")
                .limit(10)
                .offset(5)
                .build();

        try {
            Paging<Artist> artistPaging = getUsersTopArtistsRequest.execute();

            return artistPaging.getItems();
        } catch (Exception e) {
            System.out.println("Something went wrong!\n" + e.getMessage());
        }

        return new Artist[0];
    }
}
