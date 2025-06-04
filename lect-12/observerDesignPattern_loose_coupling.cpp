#include<iostream>
#include<bits/stdc++.h>

using namespace std;
/*
so what i did write here is now update method will have a param ch of type channel*
to ab jo bhi channel hoga jo UPDATE ko call karega uski ka getvideo aur getname ayega 

ab UPDATE ko NOTIFY call karega 

void notify()override{
    for(auto sub:subscribers){
        // change here 
        // now we are sending this refernce only 
        sub->update(this);
    }
}

since notify channel ka hi part hai to sirf this send krke hum ise send kr sakte hai 


*/

class channel; //(Forward declaration)
// subscribers ko channel chaiye but vo humare me neeche bana hai to ye (Forward declaration) khete hai 

class Isubscriber{
    public:
    virtual void update(channel *ch)=0;
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
        // change here 
        // now we are sending this refernce only 
        sub->update(this);
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
string getname(){
    return name;
}

};

class subscriber:public Isubscriber{
    private:
    string name;
   // channel *channels;

    public:
    subscriber(string name){
        this->name=name;
       // this->channels=channels;
    }
    void update(channel *ch)override{
        // ye jake observable ha jo class hai uska function call kr rahi hai 
        cout<<name<<" , "<<ch->getvideo()<<ch->getname()<<endl;
    }
};

int main(){

    channel *first=new channel("my youtube channel ");


    // hum chaye to is first ko bhi hata sakte hai kyuki earlies code me channel ki zaruart thi ab nhi hai 
    // subscriber* phela=new subscriber("ram",first);
    // subscriber* dusra=new subscriber("sham",first);

    subscriber *phela=new subscriber("ram");
    subscriber *dusra=new subscriber("sham");

    channel *second=new channel("dsa ka channel");

    first->subscribe(phela);
    first->subscribe(dusra);
    second->subscribe(phela);

    
    first->uploadvideo("my first video");

    second->uploadvideo("dsa tricks");


    first->unsubscribe(dusra);

    first->uploadvideo("one of my subscriber left me ");



    return 0;

}