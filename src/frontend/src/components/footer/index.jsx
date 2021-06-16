import React, {useEffect, useState} from 'react';
import './styles/Footer.css'
import PlayCircleOutlineIcon from "@material-ui/icons/PlayCircleOutline";
import SkipPreviousIcon from "@material-ui/icons/SkipPrevious";
import SkipNextIcon from "@material-ui/icons/SkipNext";
import ShuffleIcon from "@material-ui/icons/Shuffle";
import RepeatIcon from "@material-ui/icons/Repeat";
import {PlaylistPlay, VolumeDown} from "@material-ui/icons";
import {Slider, Grid} from "@material-ui/core";
import PauseIcon from '@material-ui/icons/Pause';
import VolumeOffIcon from '@material-ui/icons/VolumeOff';

const Footer = () => {
    const [audio] = useState(new Audio('https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3'));
    const [playing, setPlaying] = useState(false);
    const [mute, setMute] = useState(false)
    const toggle = () => setPlaying(!playing);
    const muteMusic = () => setMute(!mute);

    useEffect(() => {
        playing ? audio.play() : audio.pause();
        mute ? audio.muted = false : audio.muted = true;
    }, [playing, mute])

    useEffect(() => {
        audio.addEventListener('ended', () => setPlaying(false));
        return () => {
            audio.removeEventListener('ended', () => setPlaying(false));
        }
    })
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
                <button className={'btn'} onClick={toggle}>{playing ?
                    <PauseIcon fontSize='large' className='footer__icon'/> :
                    <PlayCircleOutlineIcon fontSize='large' className='footer__icon'/>}</button>
                <SkipNextIcon className='footer__icon'/>
                <RepeatIcon className='footer__green'/>
            </div>

            <div className='footer__right'>
                <Grid container spacing={2}>
                    <Grid item>
                        <PlaylistPlay/>
                    </Grid>
                    <Grid item>
                        <button className={'btn'} onClick={muteMusic}>{mute ? <VolumeDown/> : <VolumeOffIcon/>}</button>
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
