package Project.handler;

import Project.Request;
import Project.Response;

public class AuthHandler extends Handler {

    private boolean isvalidToken(String token){
        if(token!=null && token.equals("valid_123")){
            return true;
        }
        else{
            return false;
        }
    }
    private String getUserId(String s){

        return "User01";
    }


    @Override
    public Response handler(Request request){

        System.out.println("AuthHandler: Checking authentication...");

        if(!isvalidToken(request.authtoken)){
            System.out.println("AuthHandler: invalid token");
            return new Response(401,"unauthorised user");

        }
        request.userId=getUserId(request.authtoken);
        System.out.println("AuthHandler: Authenticated user "+request.userId);

        if(nextHandler!=null) return nextHandler.handler(request);
        
        return new Response(200, "OK");

    }
    
}
