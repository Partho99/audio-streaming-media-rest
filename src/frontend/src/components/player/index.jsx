import React from 'react';
import Sidebar from "../sidebar";
import Body from "../body";
import Footer from "../footer";
import './styles/Player.css'

const Player = ({}) => {
    return (
        <div className={'player'}>
            <div className={'player__body'}>
                {/*  Sidebar  */}
                <Sidebar/>
                {/*  Body  */}
                <Body />
            </div>

            {/*  Footer  */}
            <Footer/>
        </div>
    );
};

export default Player;
