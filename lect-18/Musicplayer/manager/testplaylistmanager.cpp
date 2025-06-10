#include<iostream>
#include<bits/stdc++.h>
#include "./Playlist.hpp"

using namespace std;
int main(){
    Songs*rehja=new Songs("reh ja ","ayushman","user/downloads");
    Songs*leja=new Songs("le ja ","punjabi","user/downloads");

    Playlist*playlist=new Playlist("first playlist");

    playlist->addSongInPlaylist(rehja);
    playlist->addSongInPlaylist(leja);
    
    return 0;
}