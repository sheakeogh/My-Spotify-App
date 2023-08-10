import React from "react";
import { Button } from '@material-ui/core';

import { withRouter } from "react-router-dom";

function LandingPage() {

  const getSpotifyUserLogin = () => {
    fetch("http://localhost:8080/api/login")
    .then((response) => response.text())
    .then(response => {
      window.location.replace(response);
    })
  }

  return (
    <div>
      <div style={{display: "flex", justifyContent: "center"}}>
        <h1>Welcome to Spotty!</h1>
      </div>

      <div style={{display: "flex", justifyContent: "center"}}>
        <h1>
          Please login with Spotify to get started!
        </h1>
      </div>
      <div style={{display: "flex", justifyContent: "center", margin: "1rem"}}>
        <Button variant = "contained" color = "primary" onClick = {getSpotifyUserLogin}>Sign In</Button>
      </div>


    </div>

  );
}

export default withRouter(LandingPage);
