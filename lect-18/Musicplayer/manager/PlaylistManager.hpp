#pragma once
#include<iostream>
#include<bits/stdc++.h>
#include "./Playlist.hpp"

using namespace std;

class PlaylistManager{
    private:
    static PlaylistManager*instance;
    unordered_map<string,Playlist*> playlists;
    PlaylistManager() {};
    
    public:
    static PlaylistManager*getinstane(){
        if(!instance){
            return new PlaylistManager();
        }
        return instance;
    }

    void createPlaylist(string name){
        if(playlists.count(name)){
            cout<<name<<" playlist already added"<<endl;
        }

        playlists[name]=new Playlist(name);
        // ye jabhi kr sakte hai jab  unordered_map<string,Playlist*> playlists; ye ho 
        //  unordered_map<string,Playlist> playlists; agar ye hua to nhi hoga 

    }
    void addSongsToPlaylist(string playlistname,Songs*song){
        if(!playlists.count(playlistname)){
            cout<<"no such playlist exists"<<endl;
        }
        playlists[playlistname]->addSongInPlaylist(song);
        // in wala function playlist ka hai 
        // to wla manager ka hai 

    }
    Playlist*getPlaylist(string name){
        if(!playlists[name]){
            cout<<"this playlist doesn't exists"<<endl;
            return nullptr;
        }
        return playlists[name];

    }

};
PlaylistManager*PlaylistManager::instance=nullptr;