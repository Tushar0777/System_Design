//https://chatgpt.com/share/6846eabc-329c-800f-a519-50a42db73ef9
//https://chat.deepseek.com/a/chat/s/b8687693-6142-4382-b274-480a22c9c505

#include<iostream>
#include<bits/stdc++.h>

using namespace std;

class Xmldata{
    string xmldata;
    public:

    Xmldata(string pxmldata){
        xmldata=pxmldata;
    }
    string getdata(){
        return xmldata;
    }

};

class analatics{
    string json;
    public:
   // analatics(){};
    analatics(string pjson){
        json=pjson;
    }
   virtual void analysis(){
        cout<<"analysing data "<<json<<endl;
    }
    virtual ~analatics() {};
};

class adaptor:public analatics{
    // iska kam hai ki xml ko jason me krna 
   // Xmldata *xmldata;

    public:
    adaptor(Xmldata *pxmldata):analatics(converttojson(pxmldata->getdata())){};

    string converttojson(string xml){
        return  "{\"data\": \"" + xml + "\"}";

    }
    void analysis()override{
        cout<<"converting xml data to json to json "<<endl;
        analatics::analysis(); /// base class ka analysis call kara kyuki constructor se 
        // vahi gya hai 
    }
};

class client{
 //   analatics dataanalytics;

    // client(analatics *pdataanalytics){
    //     dataanalytics->pdataanalytics;
    // };
    public:

    void getans(analatics *dataanalytics){
        dataanalytics->analysis();
    }

};

int main(){
    string data="some xmldata";
   // Xmldata *xmldata=new Xmldata(data);
   Xmldata *xmldata=new Xmldata("some xml data");
   analatics *processing=new adaptor(xmldata);
   client user;
   user.getans(processing);
   cout<<"---------------------------"<<endl;
  string data1= xmldata->getdata();
  cout<<data1<<endl;
   delete processing;
    delete xmldata;
    return 0;
}
