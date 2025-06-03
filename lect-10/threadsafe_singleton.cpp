#include<iostream>
#include<bits/stdc++.h>

using namespace std;

class singleton{
    private:
    static singleton*instance;
    static mutex mtx;

    singleton(){
        cout<<"singleton instanciated"<<endl;
    }

    public:
    // this is not thread safe so to make it thread safe 
    static singleton*getinstance(){
        lock_guard<mutex>lock(mtx);
        if(instance==nullptr){
            instance=new singleton();
        }
        return instance;
    }
};

singleton*singleton::instance=nullptr;
mutex singleton::mtx;

int main(){
    singleton*ex=singleton::getinstance();
    cout<<ex<<endl;
    return 0;

}
