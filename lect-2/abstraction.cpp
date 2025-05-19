#include<iostream>
#include<bits/stdc++.h>

using namespace std;

class car{
public:
virtual void startEngine()=0;
virtual void shiftGear(int gear)=0;
virtual void acceleration()=0;
virtual void brake()=0;
virtual void stopEngine()=0;
virtual ~car(){}
};

class sportscar:public car{
    public:
    string brand;
    string model;
    bool isEngineOn;
    int currSpeed;
    int currGear;

    sportscar(string b,string m){
        this->brand=b;
        this->model=m;
        isEngineOn=false;
        currSpeed=0;
        currGear=0;

    }
    void startEngine(){
        isEngineOn=true;
        cout<<model<<" "<<brand<<" : engine starts with ror"<<endl;
    }
    void shiftGear(int gear){
        if(!isEngineOn){
            cout<<"cannot change the gear as engine is off"<<endl;
        }
        else{
            currGear=gear;
            cout<<brand<<" "<<model<<" : shifted gear "<<currGear<<endl;
        }
    }
    void acceleration(){
        if(!isEngineOn){
            cout<<"cannot acc car"<<endl;
        }
        else{
            currSpeed+=20;
            cout<<model<<" : current speed is "<<currSpeed<<endl;
        }
    }
    void brake(){
        currSpeed-=20;
        cout<<model<<" : BREAKING! current speed is "<<currSpeed<<endl;
    }
    void stopEngine(){
        isEngineOn=false;
        currSpeed=0;
        currGear=0;
        cout<<model<<" : engine is off"<<endl;
    }

};

int main(){
    car *mycar=new sportscar("ford","mustang");

    mycar->startEngine();
    mycar->shiftGear(1);
    mycar->acceleration();
    mycar->shiftGear(2);
    mycar->acceleration();
    mycar->brake();
    mycar->stopEngine();

    delete mycar;

    return 0;
}