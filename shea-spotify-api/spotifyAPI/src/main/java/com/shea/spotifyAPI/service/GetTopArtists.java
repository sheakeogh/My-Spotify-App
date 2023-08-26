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

    public static Paging<Artist> getUserTopArtistsPage(String time_range, int limit, int offset) {
        log.debug("GetTopArtists.getUserTopArtistsPage :: Beginning Execution");
        log.debug("GetTopArtists.getUserTopArtistsPage :: Executing with params: time_range(" + time_range +
                ") + limit(" + limit + ") + offset(" + offset + ")");
        GetUsersTopArtistsRequest getUsersTopArtistsRequest = spotifyApi.getUsersTopArtists()
                .time_range(time_range)
                .limit(limit)
                .offset(offset)
                .build();
        try {
            return getUsersTopArtistsRequest.execute();
        } catch (Exception e) {
            log.error("Something went wrong!\n" + e.getMessage());
        }

        return null;
    }
}