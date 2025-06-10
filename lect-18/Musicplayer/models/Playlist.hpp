#pragma once
#include<iostream>
#include<bits/stdc++.h>
#include "Songs.hpp"

using namespace std;

class Playlist{
    private:
    vector<Songs*>songsPlaylist;
    string playlistName;

    public:
    Playlist(string name){
        playlistName=name;
    }
    string getPlaylistname(){
        return playlistName;
    }

    void addSongInPlaylist(Songs*song){
        if(song==nullptr){
            cout<<"can't add null song to playlist"<<endl;
        }
        songsPlaylist.push_back(song);

    }
    int size(){
        cout<<(int)songsPlaylist.size()<<endl;
    }
    vector<Songs*>getsongs(){
        return songsPlaylist;
    }

};