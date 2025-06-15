package Project.handler;

import Project.Request;
import Project.Response;

public class ControlHandler extends Handler {

    public Response handler(Request request){
       // System.out.println("");
        System.out.println("ControllerHandler: Handling business logic for user " + request.userId + " at " + request.path);

        String data="Hello " + request.userId + ", here is your data for " + request.path;

        return new Response(200, data);
    }
    
}
