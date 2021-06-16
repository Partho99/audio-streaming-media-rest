import React from 'react';
import './styles/SongRow.css'
const SongRow = ({track}) => {
    return (
        <div className={'songRow'}>
            <img className={'songRow__album'} src={''} alt={'ROW'}/>
            <div className='songRow__info'>
                <h1>{track}</h1>
                <p>
                    track full description
                </p>
            </div>
        </div>
    );
};

export default SongRow;
