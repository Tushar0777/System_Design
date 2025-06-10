#pragma once
#include<iostream>
#include<bits/stdc++.h>

using namespace std;

class Songs{
    private:
    string title;
    string artist;
    string filepath;

    public:
    Songs(string t,string a,string fp){
        this->title=t;
        this->artist=a;
        this->filepath=fp;
    }
    string getTitle(){
        return title;

    }

    string getArtist(){
        return artist;
    }
    string getFilePath(){
        return filepath;
    }
};

