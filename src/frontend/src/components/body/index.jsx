import React from 'react';
import './styles/Body.css'
import {Favorite, MoreHoriz, PlayCircleFilled} from "@material-ui/icons";
import Header from "../header";
import SongRow from "../song-row";

const Body = ({}) => {
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
                <SongRow track='abcdef'/>
                <SongRow track='abcdef'/>
                <SongRow track='abcdef'/>
                <SongRow track='abcdef'/>
                <SongRow track='abcdef'/>
            </div>
        </div>
    );
};

export default Body;
