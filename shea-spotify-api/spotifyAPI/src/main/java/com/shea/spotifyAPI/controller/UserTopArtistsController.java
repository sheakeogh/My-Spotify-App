package com.shea.spotifyAPI.controller;

import com.shea.spotifyAPI.service.GetTopArtists;
import com.wrapper.spotify.model_objects.specification.Artist;
import com.wrapper.spotify.model_objects.specification.Image;
import com.wrapper.spotify.model_objects.specification.Paging;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 4800)
@Slf4j
public class UserTopArtistsController {

    @GetMapping(value = "/user-top-artists")
    public List<String> getUserTopArtists() {
        List<Artist> artistList = Arrays.stream(GetTopArtists.getUserTopArtistsPage().getItems()).toList();
        List<String> artistNameList = new ArrayList<>();

        Paging<Artist> artistPaging = GetTopArtists.getUserTopArtistsPage();

        for (Artist artist : Arrays.stream(artistPaging.getItems()).toList()) {
            artistNameList.add(artist.getName());
        }

        return artistNameList;
    }

    @GetMapping(value = "/user-top-artists/images")
    public List<String> getUserTopArtistsImages() {
        List<Artist> artistList = Arrays.stream(GetTopArtists.getUserTopArtistsPage().getItems()).toList();
        List<Image[]> imageArrayList = new ArrayList<>();
        List<String> imageList = new ArrayList<>();

        for (Artist artist : artistList) {
            imageArrayList.add(artist.getImages());
        }

        for (Image[] image : imageArrayList) {
            imageList.add(image[0].getUrl());
        }

        return imageList;
    }
}
