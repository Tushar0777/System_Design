package Project;

public class Response {
    int statuscode;
    String message;

    public Response(int statuscode,String message){
        this.statuscode=statuscode;
        this.message=message;
    }
    @Override
    public String toString(){
        return statuscode + " : "+message;
        //System.out.println();  
    }
}
