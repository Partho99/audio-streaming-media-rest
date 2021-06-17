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
import RepeatOneIcon from '@material-ui/icons/RepeatOne';
import Replay10Icon from '@material-ui/icons/Replay10';
import music from '../../musics/linkinpark.mp3'

const Footer = () => {
    const [audio] = useState(new Audio(music));
    const [playing, setPlaying] = useState(false);
    const [mute, setMute] = useState(true)
    const [value, setValue] = useState(20);
    const [repeat, setRepeat] = useState(false)
    const toggle = () => setPlaying(!playing);
    const muteMusic = () => setMute(!mute);
    const repeatMusic = () => setRepeat(!repeat)

    useEffect(() => {
        playing ? audio.play() : audio.pause();
        audio.loop = repeat;
        mute ? audio.muted = false : audio.muted = true;
        audio.volume = value / 100;
        mute ?  setValue(value) : setValue(0) ;
    }, [playing, mute, value, repeat])

    useEffect(() => {
        audio.addEventListener('ended', () => setPlaying(false));
        return () => {
            audio.removeEventListener('ended', () => setPlaying(false));
        }
    })

    const handleChange = (event, newValue) => {
        setValue(newValue);
    };

    return (
        <div className='footer'>
            <div className='footer__left'>
                <img
                    className='footer__albumLogo'
                    src='https://angelacampbellblog.files.wordpress.com/2016/11/4f1691b44506ee4b727454799b8488f7.jpg'
                    alt=''/>
                <div className='footer__songInfo'>
                    <h4>In the end</h4>
                    <p>Linkin Park</p>
                </div>
            </div>

            <div className='footer__center'>
                <ShuffleIcon className='footer__green'/>
                <SkipPreviousIcon className='footer__icon'/>
                <button className={'btn'} onClick={toggle}>{playing ?
                    <PauseIcon fontSize='large' className='footer__icon'/> :
                    <PlayCircleOutlineIcon fontSize='large' className='footer__icon'/>}</button>
                <SkipNextIcon className='footer__icon'/>
                <button className={'btn'} onClick={repeatMusic}>{repeat ?
                    <RepeatOneIcon className='footer__green'/> : <RepeatIcon className='footer__green'/>}</button>
                <Replay10Icon className='footer__green'/>
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
                        <Slider
                            value={value} onChange={handleChange} aria-labelledby="continuous-slider"
                        />
                    </Grid>
                </Grid>
            </div>
        </div>
    );
};

export default Footer;
