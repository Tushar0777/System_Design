package Project;

import Project.handler.Handler;
import Project.handler.AuthHandler;

public class Main {
    public static void main(String[] args) {
        Request request=new Request("get", "valid_123", "/user");
        Request request2=new Request("get", "Valid_123", "/user");

        Handler auth=new AuthHandler();

        System.out.println(auth.handler(request));
        System.out.println();
        System.out.println(auth.handler(request2));
    }
}
