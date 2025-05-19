/*
gpt link of questions from this topic as well as code 
https://chatgpt.com/share/682b1de3-8650-800f-a479-95c74f5745b0
*/

#include<iostream>
#include<bits/stdc++.h>

using namespace std;


/*
Abstract class --> Act as an interface for Outsiude world to operate the car. 
This abstract class tells 'WHAT' all it can do rather then 'HOW' it does that.
Since this is an abstract class we cannot directly create Objects of this class. We
need to Inherit it first and then that child class will have the responsibility to 
provide implementation details of all the abstract (virtual) methods in the class.

*/

class car{
public:
virtual void startEngine()=0;
virtual void shiftGear(int gear)=0;
virtual void acceleration()=0;
virtual void brake()=0;
virtual void stopEngine()=0;
virtual ~car(){}
};

/*
This is a Concrete class (A class that provide implementation details of an abstract class).
Now anyone can make an Object of 'SportsCar' and can assign it to 'Car' (Parent class) pointer 
(See main method for this)

 to denote a real world car in programming we created 2 classes.
One to deonte all the user-interface like pedals, buttons, stearing wheels etc ('Car' class).
And another one to denote the actual car with all the implementations of these buttons (SportsCar' class).

*/

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