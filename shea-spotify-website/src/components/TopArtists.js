import {withRouter} from "react-router-dom";
import React, { useEffect, useState } from 'react'




function TopArtists() {

    const [userTopArtists, setUserTopArtists] = useState();
    const [userTopArtistsImages, setUserTopArtistsImages] = useState();

    useEffect(() => {
        fetch("http://localhost:8080/api/user-top-artists")
        .then(response => response.json())
        .then(data => {
            console.log(data)
            setUserTopArtists(data)
            })
    }, [])

    useEffect(() => {
        fetch("http://localhost:8080/api/user-top-artists/images")
        .then(response => response.json())
        .then(data => {
            console.log(data)
            setUserTopArtistsImages(data)
            })
    }, [])

    return (
        <div>
            {userTopArtists ? (
                userTopArtists.map((artistResult) => {
                    return (
                        <h1 key={artistResult}>{artistResult}</h1>
                    )
                })
            ):
            (
                <h1>LOADING...</h1>
            )}
            {userTopArtistsImages ? (
                userTopArtistsImages.map((artistImagesResult) => {
                    return (
                        <img alt="Artist Profile" src={artistImagesResult}></img>
                    )
                })
            ):
            (
                <h1>LOADING...</h1>
            )}
        </div>
    );
}

export default withRouter(TopArtists);
