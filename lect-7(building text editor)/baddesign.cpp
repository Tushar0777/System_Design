#include<iostream>
#include <bits/stdc++.h>

using namespace std;

class Documentation{
    private:
    vector<string>documentelements;
    string rendereddocument;

    public:
    void addtext(string s){
        documentelements.push_back(s);
    }
    void addimage(string path){
        documentelements.push_back(path);
    }

    string renderDocument(){
        if(rendereddocument.empty()){
            string result;
            for(auto ele:documentelements){
                if(ele.size()>4 && ele.substr(ele.size()-4)==".jpg"){
                    result+="[image:"+ele+ "]"+"\n";
                }
                else{
                    result+=ele+"\n";
                }
            }
            rendereddocument=result;

        }
        return rendereddocument;
    }
    void savetofile(){
        ofstream file("document.txt");
        if(file.is_open()){
            file<<renderDocument();
            file.close();
            cout<<"document saved to document.txt"<<endl;

        }
        else{
            cout<<"enable to open file for writting purposes"<<endl;
        }
    }

};

int main(){
  //  Documentation  *doc=new Documentation;
    Documentation doc;
    doc.addtext("hello world");
    doc.addimage("imgage.jpg");
    cout<<doc.renderDocument()<<endl;;
    doc.savetofile();
    return 0;
}