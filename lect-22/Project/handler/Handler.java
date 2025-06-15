package Project.handler;

import Project.Request;
import Project.Response;

public abstract class Handler {
    protected Handler nextHandler;

    public Handler(){
        this.nextHandler=null;
    }

    public void setHandler(Handler next){
        this.nextHandler=next;
    }
    public abstract Response handler(Request request);
    
}
