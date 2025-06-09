//https://chatgpt.com/share/6845e12e-77c4-800f-bd61-2883f2b9abe8

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
    analatics(){};
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
    Xmldata *xmldata;

    public:
    adaptor(Xmldata *pxmldata){
        xmldata=pxmldata;
    }
    void analysis()override{
        cout<<"converting xml data to json "<<xmldata->getdata()<<" to json "<<endl;
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
    return 0;
}