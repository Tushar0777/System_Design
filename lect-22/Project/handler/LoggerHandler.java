package Project.handler;

import Project.Request;
import Project.Response;

public class LoggerHandler extends Handler {

    @Override
    public Response handler(Request request){
        long startTime=System.currentTimeMillis();
        System.out.println("LoggerHandler: Received request for " + request.path);

        Response response;

        if(nextHandler!=null){
            response=nextHandler.handler(request);
        }
        else{
            response=new Response(200,"OK");
        }
        long endTime=System.currentTimeMillis();
        long duration=endTime-startTime;
         System.out.println("LoggerHandler: " +
            "User: " + request.userId +
            ", Endpoint: " + request.path +
            ", Method: " + request.method +
            ", Status: " + response.statuscode +
            ", Duration: " + duration + "ms");


        return response;

    }    
}
