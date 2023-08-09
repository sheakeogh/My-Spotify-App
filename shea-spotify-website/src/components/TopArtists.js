import {withRouter} from "react-router-dom";
// import {React, useEffect, useState} from "react";
import React, { useEffect, useState } from 'react'




function TopArtists() {

    const [userTopArtists, setUserTopArtists] = useState();

    useEffect(() => {
        fetch("http://localhost:8080/api/user-top-artists")
        .then(response => response.json())
        .then(data => {
            console.log(data)
            setUserTopArtists(data)
            })
    }, [])

    return (
        <div>
            {userTopArtists ? (
                userTopArtists.map((artistResult) => {
                    return <h1 key= {artistResult.name}>{artistResult.name}</h1>
                })
            ):
            (
                <h1>LOADING...</h1>
            )}
        </div>
    );
}

export default withRouter(TopArtists);