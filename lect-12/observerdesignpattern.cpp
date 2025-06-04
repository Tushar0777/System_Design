#include<iostream>
#include<bits/stdc++.h>

using namespace std;

class Isubscriber{
    public:
    virtual void update()=0;
    virtual ~Isubscriber(){}

};

class Ichannel{
    public:
    virtual void subscribe(Isubscriber *subscriber)=0;
    virtual void unsubscribe(Isubscriber *subsriber)=0;
    virtual void notify()=0;
    virtual ~Ichannel(){}
};

class channel:public Ichannel{
vector<Isubscriber*>subscribers;
string name;
string latestvideo;

public:
    channel(string name){
        this->name=name;
    }

void subscribe(Isubscriber *subscriber)override{

    if(find(subscribers.begin(),subscribers.end(),subscriber)==subscribers.end()){
        subscribers.push_back(subscriber);
    }
}
void unsubscribe(Isubscriber *subscriber)override{
    auto it=find(subscribers.begin(),subscribers.end(),subscriber);

    if(it!=subscribers.end()){
        subscribers.erase(it);
    }
}

void notify()override{
    for(auto sub:subscribers){
        sub->update();
    }
}

void uploadvideo(string title){
    latestvideo=title;
    cout<<"new video uploaded "<<latestvideo<<"of the channel "<<name<<endl;
    notify();
}

string getvideo(){
    // return "check out our new video "+latestvideo;
    return "\nCheckout our new Video : " + latestvideo + "\n";
}

};

class subscriber:public Isubscriber{
    private:
    string name;
    channel *channels;

    public:
    subscriber(string name,channel*channels){
        this->name=name;
        this->channels=channels;
    }
    void update()override{
        // ye jake observable ha jo class hai uska function call kr rahi hai 
        cout<<"hey "<<name<<" , "<<channels->getvideo()<<endl;


    }
};

int main(){

    channel *first=new channel("my youtube channel ");

    subscriber* phela=new subscriber("ram",first);
    subscriber* dusra=new subscriber("sham",first);

    first->subscribe(phela);
    first->subscribe(dusra);
    
    first->uploadvideo("my first video");


    first->unsubscribe(dusra);

    first->uploadvideo("one of my subscriber left me ");





    return 0;

}