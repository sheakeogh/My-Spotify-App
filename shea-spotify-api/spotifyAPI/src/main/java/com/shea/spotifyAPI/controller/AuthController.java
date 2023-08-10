package com.shea.spotifyAPI.controller;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.credentials.AuthorizationCodeCredentials;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeRequest;
import com.wrapper.spotify.requests.authorization.authorization_code.AuthorizationCodeUriRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.core5.http.ParseException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 4800)
@Slf4j
public class AuthController {

    public static SpotifyApi spotifyApi = new SpotifyApi.Builder()
            .setClientId("5079883d0bec4f3d8705d674439e4988")
            .setClientSecret("9b92b73c7bf44a4daa2bf435110093e3")
            .setRedirectUri(SpotifyHttpManager.makeUri("http://localhost:8080/get-user-code/"))
            .build();

    @GetMapping("/login")
    @ResponseBody
    public String spotifyLogin() {
        AuthorizationCodeUriRequest authorizationCodeUriRequest = spotifyApi.authorizationCodeUri()
                .scope("user-read-private, user-read-email, user-top-read")
                .show_dialog(true)
                .build();

        log.debug("AuthController.spotifyLogin making URI for login :: {}", authorizationCodeUriRequest.execute().toString());

        return authorizationCodeUriRequest.execute().toString();
    }

    @GetMapping(value = "/get-user-code")
    public void getSpotifyUserCode(@RequestParam("code") String userCode, HttpServletResponse response) throws IOException {
        AuthorizationCodeRequest authorizationCodeRequest = spotifyApi.authorizationCode(userCode).build();

        try {
            AuthorizationCodeCredentials authorizationCodeCredentials = authorizationCodeRequest.execute();

            // Set access and refresh token for further "spotifyApi" object usage
            spotifyApi.setAccessToken(authorizationCodeCredentials.getAccessToken());
            spotifyApi.setRefreshToken(authorizationCodeCredentials.getRefreshToken());

        } catch (IOException | ParseException | SpotifyWebApiException e) {
            System.out.println("Error: " + e.getMessage());
        }

        response.sendRedirect("http://localhost:3000/top-artists");
    }
}
