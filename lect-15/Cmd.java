//https://chatgpt.com/share/68449f8a-9330-800f-bf40-413ab5f37a1b
// do check it out and iske 10 question zarur kario 

import java.util.*;

class airconditioner{
    int temp;

    public void turnon(){
        System.out.println("ac turned on");
    }
    public void turnoff(){
        System.err.println("ac turned off");
    }
    public void settemp(int temprature){
        this.temp=temprature;
        System.out.println("ac temp changed to "+temp);

    }
    public int gettemp(){
        return this.temp;
    }
}

interface Icommand {
    public void execute();
    public void undo();
    
}


class turnOnAcCmd implements Icommand{
    airconditioner ac;


    turnOnAcCmd(airconditioner ac){
        this.ac=ac;
    }

    
    @Override
    public void execute(){
        ac.turnon();
    }

    @Override
    public void undo(){
        ac.turnoff();
    }
}

class turnOffAcCmd implements Icommand{
    airconditioner ac;


    turnOffAcCmd(airconditioner ac){
        this.ac=ac;
    }

    
    @Override
    public void execute(){
        ac.turnoff();
    }
    
    @Override
    public void undo(){
        ac.turnon();
    }
}



class setactemp implements Icommand{
    airconditioner ac;
    private int nexttemp;
    private int prevtemp;

    setactemp(airconditioner ac,int temp){
        this.ac=ac;
        this.nexttemp=temp;
    }
    @Override
    public void execute(){

        prevtemp=ac.gettemp();
        ac.settemp(nexttemp);


    }
    @Override
    public void undo(){
        ac.settemp(prevtemp);

    }
}


class myremote{
    Stack<Icommand>accommandhistory=new Stack<>();
    Icommand command;

    myremote(){};

    public void setcommand(Icommand command){
        this.command=command;
    }
    public void pressbutton(){
        command.execute();
        // command ko save krdi
        accommandhistory.add(command);
    }
    public void undo(){
        if(accommandhistory.isEmpty()==false){
            Icommand lastcommand=accommandhistory.pop();
            lastcommand.undo();
        }

    }
}
public class Cmd{
public static void main(String[] args) {
    airconditioner ac=new airconditioner();
    myremote remote=new myremote();

    remote.setcommand(new turnOnAcCmd(ac));
    
    remote.pressbutton();
    remote.setcommand(new setactemp(ac,25));
    remote.pressbutton();

    remote.setcommand(new setactemp(ac,18 ));
    remote.pressbutton();

    remote.undo();

    remote.undo(); 
}
}