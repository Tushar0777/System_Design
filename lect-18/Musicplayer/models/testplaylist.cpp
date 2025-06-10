#pragma once
#include<iostream>
#include<bits/stdc++.h>
//#include "Songs.hpp"
#include "Playlist.hpp"
//#include "Songs.hpp"
//#include "Playlist.hpp"

using namespace std;

int main(){

    Songs*rehja=new Songs("reh ja ","ayushman","user/downloads");
    Songs*leja=new Songs("le ja ","punjabi","user/downloads");

    Playlist*playlist=new Playlist("first playlist");

    playlist->addSongInPlaylist(rehja);
    playlist->addSongInPlaylist(leja);

    cout<<"size of playlist"<<playlist->size()<<endl;

    cout<<playlist->getPlaylistname()<<endl;

    auto allsongs=playlist->getsongs();

    for(auto it:allsongs){
        cout<<it->getTitle()<<" "<<endl;
    }



    return 0;
}
