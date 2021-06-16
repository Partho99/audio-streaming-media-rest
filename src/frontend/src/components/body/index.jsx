import React, {useEffect, useState} from 'react';
import './styles/Body.css'
import {Favorite, MoreHoriz, PlayCircleFilled} from "@material-ui/icons";
import Header from "../header";
import SongRow from "../song-row";

const Body = ({}) => {
    const [music, setMusic] = useState([]);
    useEffect(() => {
        let mounted = true;
        const songData = async () => {
            await fetch('http://localhost:5050/show-song')
                .then(data => data.json())
                .then(data => mounted ? setMusic(data) : null)
        }
        songData().then();
    }, [setMusic])
    return (
        <div className='body'>
            <Header/>
            <div className='body__info'>
                <img src={''} alt=''/>
                <div className='body__infoText'>
                    <strong>PLAYLIST</strong>
                    <h2>Discover Weekly</h2>
                    <p>Discover Weekly</p>
                </div>
            </div>
            <div className='body__songs'>
                <div className='body__icons'>
                    <PlayCircleFilled className='body__shuffle'/>
                    <Favorite fontSize='large'/>
                    <MoreHoriz/>
                </div>
                {music?.map(m => (
                    <SongRow track={m.name}/>
                ))}

            </div>
        </div>
    );
};

export default Body;
