import React from 'react';
import './styles/Sidebar.css'
import SidebarOption from "./sidebar-options";
import {Home, Search, LibraryMusic} from "@material-ui/icons";

const Sidebar = () => {

    // const [{playlists}, dispatch] = useDataLayerValue();

    return (
        <div className='sidebar'>
            <img
                className='sidebar__logo'
                src='https://www.getapkfile.com/wp-content/uploads/2018/07/Music-Player-APK-Download-Android-APP-150x150.png'
                alt='player'
            />
            <SidebarOption Icon={Home} title='Home'/>
            <SidebarOption Icon={Search} title='Search'/>
            <SidebarOption Icon={LibraryMusic} title='Your Library'/>
            <br/>
            <strong className='sidebar__title'>PLAYLIST</strong>
            <hr/>
            {/*{playlists?.items?.map(playlist => (*/}
            {/*    <SidebarOption title={playlist.name}/>*/}
            {/*))}*/}
        </div>
    );
};

export default Sidebar;

