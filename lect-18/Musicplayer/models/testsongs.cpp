
#include "Songs.hpp"
int main(){
    Songs *sg=new Songs("song1","artits1","/user/downloads");

    string artist=sg->getArtist();
    string title=sg->getTitle();
    string filepath=sg->getFilePath();

    cout<<artist<<" "<<title<<" "<<filepath<<endl;
     
    delete sg;
    return 0;
}