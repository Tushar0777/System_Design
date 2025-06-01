#include<iostream>
#include<bits/stdc++.h>

using namespace std;

class burger{
    public:
    virtual void prepare()=0;
    virtual ~burger(){};
};

class simpleburger:public burger{
    public:
    void prepare()override{
        cout<<"simple burger"<<endl;
    }
};

class standardburger:public burger{
    public:
    void prepare()override{
        cout<<"standard burger"<<endl;
    }
};

class premiuimburger:public burger{
    public:
    void prepare()override{
        cout<<"premium burger"<<endl;
    }
};

class burgerfactory{
   // protected:burger food;

    public:
    burger*create(string type){
        if(type=="simple"){
            return new simpleburger();
        }
        else if(type=="standard"){
            return new standardburger();
        }
        else if(type=="premium"){
            return new premiuimburger();
        }
        else{
            cout<<"no such burger type exists "<<endl;
            return NULL;
        }
    }
};

int main(){

    burgerfactory *factory=new burgerfactory();
    burger * food=factory->create("simple");
    food->prepare();
    return 0;

}