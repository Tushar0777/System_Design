package Project;

import Project.handler.Handler;
import Project.handler.LoggerHandler;
import Project.handler.RateLimiterHandler;
import Project.handler.AuthHandler;
import Project.handler.ControlHandler;

public class Main {
    public static void main(String[] args) {
        Request request=new Request("get", "valid_123", "/user");
        Request request2=new Request("get", "Valid_123", "/user");

        Handler auth=new AuthHandler();
        Handler ratelimiter=new RateLimiterHandler();
        Handler logger=new LoggerHandler();
        Handler controller=new ControlHandler();

        // chain of responsibility
        auth.setHandler(ratelimiter);
        ratelimiter.setHandler(logger);
        logger.setHandler(controller);

       for(int i=1;i<=5;i++){
        System.out.println("\n Request #" + i);
        Response response=auth.handler(request);
        //System.out.println(response);
        System.out.println(" Final Response: " + response + "\n");
       }
    }
}
