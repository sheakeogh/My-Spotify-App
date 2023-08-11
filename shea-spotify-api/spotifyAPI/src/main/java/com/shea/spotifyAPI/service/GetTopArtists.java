package com.shea.spotifyAPI.service;

import com.wrapper.spotify.model_objects.specification.*;
import com.wrapper.spotify.requests.data.personalization.simplified.GetUsersTopArtistsRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.shea.spotifyAPI.controller.AuthController.spotifyApi;

@Service
@Slf4j
public class GetTopArtists {

    public static Paging<Artist> getUserTopArtistsPage() {
        List<String> artistList = new ArrayList<>();
        GetUsersTopArtistsRequest getUsersTopArtistsRequest = spotifyApi.getUsersTopArtists()
                .time_range("medium_term")
                .limit(10)
                .offset(5)
                .build();

        try {
            return getUsersTopArtistsRequest.execute();
        } catch (Exception e) {
            System.out.println("Something went wrong!\n" + e.getMessage());
        }

        return null;
    }
}