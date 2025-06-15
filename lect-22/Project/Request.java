package Project;

public class Request {
    public String method;
    public String authtoken;
    public String path;
    public String userId;

    public Request(String method,String authtoken,String path){
        this.method=method;
        this.authtoken=authtoken;
        this.path=path;
    }
    
}


