import React from 'react';
import './styles/Footer.css'
import PlayCircleOutlineIcon from "@material-ui/icons/PlayCircleOutline";
import SkipPreviousIcon from "@material-ui/icons/SkipPrevious";
import SkipNextIcon from "@material-ui/icons/SkipNext";
import ShuffleIcon from "@material-ui/icons/Shuffle";
import RepeatIcon from "@material-ui/icons/Repeat";
import {PlaylistPlay, VolumeDown} from "@material-ui/icons";
import {Slider, Grid} from "@material-ui/core";

const Footer = () => {
    return (
        <div className='footer'>
            <div className='footer__left'>
                <img
                    className='footer__albumLogo'
                    src='https://i.redd.it/t70zhpbokdt11.jpg'
                    alt=''/>
                <div className='footer__songInfo'>
                    <h4>Yeah!</h4>
                    <p>Pusher</p>
                </div>
            </div>

            <div className='footer__center'>
                <ShuffleIcon className='footer__green'/>
                <SkipPreviousIcon className='footer__icon'/>
                <PlayCircleOutlineIcon fontSize='large' className='footer__icon'/>
                <SkipNextIcon className='footer__icon'/>
                <RepeatIcon className='footer__green'/>
            </div>

            <div className='footer__right'>
                <Grid container spacing={2}>
                    <Grid item>
                        <PlaylistPlay/>
                    </Grid>
                    <Grid item>
                        <VolumeDown/>
                    </Grid>
                    <Grid item xs>
                        <Slider/>
                    </Grid>
                </Grid>
            </div>
        </div>
    );
};

export default Footer;
