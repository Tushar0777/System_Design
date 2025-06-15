package Project.handler;

import java.util.HashMap;
import java.util.Map;

import Project.Request;
import Project.Response;

public class RateLimiterHandler extends Handler {
    private static final int limit=3;
    private Map<String,Integer> requestCount=new HashMap<>();

    public Response handler(Request request){
        System.out.println("RateLimiterHandler: Checking rate limit...");

        if(request.userId==null){
            return new Response(400, "User not authenticated before rate limit check");
        }
        int count =requestCount.getOrDefault(request.userId, 0);

        if(count>=limit){
            //System.out.println();
            System.out.println("RateLimiterHandler: User " + request.userId + " exceeded limit!");
            return new Response(429, "Too Many Requests");
        }
        requestCount.put(request.userId,count+1);
        System.out.println("RateLimiterHandler: User " + request.userId + " request #" + (count + 1));

        if(nextHandler!=null){
            return nextHandler.handler(request);
        } 

        return new Response(200, "OK");



    }
    
}
