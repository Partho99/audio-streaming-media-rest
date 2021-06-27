import React, {useEffect, useState} from 'react';
import './styles/Footer.css'
import PlayCircleOutlineIcon from "@material-ui/icons/PlayCircleOutline";
import SkipPreviousIcon from "@material-ui/icons/SkipPrevious";
import SkipNextIcon from "@material-ui/icons/SkipNext";
import ShuffleIcon from "@material-ui/icons/Shuffle";
import RepeatIcon from "@material-ui/icons/Repeat";
import {PlaylistPlay, VolumeDown} from "@material-ui/icons";
import {Slider, Grid, LinearProgress} from "@material-ui/core";
import PauseIcon from '@material-ui/icons/Pause';
import VolumeOffIcon from '@material-ui/icons/VolumeOff';
import RepeatOneIcon from '@material-ui/icons/RepeatOne';
import Replay10Icon from '@material-ui/icons/Replay10';
import { makeStyles } from '@material-ui/core/styles';
const useStyles = makeStyles({
    root: {
        width: '100%',
    },
});

const Footer = ({song}) => {
    const classes = useStyles();
    const [progress, setProgress] = React.useState(0);
    const [mp3, setMp3] = useState();
    const [audio] = useState(new Audio('musics/linkinpark.mp3'));
    const [playing, setPlaying] = useState(false);
    const [mute, setMute] = useState(true)
    const [value, setValue] = useState(20);
    const [repeat, setRepeat] = useState(false)
    const [music, setMusic] = useState([]);
    const toggle = () => setPlaying(!playing);
    const muteMusic = () => setMute(!mute);
    const repeatMusic = () => setRepeat(!repeat)

    React.useEffect(() => {
        const timer = setInterval(() => {
            setProgress((oldProgress) => {
                if (oldProgress === 100) {
                    return 0;
                }
                const diff = Math.random() * 10;
                return audio.currentTime;
            });
        }, audio.duration * 1000);

        return () => {
            clearInterval(timer);
        };
    }, []);

    useEffect(() => {
        console.log(audio)
        let mounted = true;
        const songData = async () => {
            await fetch('http://localhost:5050/show-song')
                .then(data => data.json())
                .then(data => mounted ? setMusic(data) : null)
        }
        songData().then();
    }, [setMusic])

    useEffect(() => {
        playing ? audio.play() : audio.pause();
        audio.loop = repeat;
        mute ? audio.muted = false : audio.muted = true;
        audio.volume = value / 100;
        mute ? setValue(value) : setValue(0);
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
                    <RepeatOneIcon className='footer__green'/> :
                    <RepeatIcon className='footer__green'/>}</button>
                <Replay10Icon className='footer__green'/>
                <div className='footer__center__bottom'>
                    <div className={classes.root}>
                        <LinearProgress variant="determinate" value={progress} />
                    </div>

                </div>
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
