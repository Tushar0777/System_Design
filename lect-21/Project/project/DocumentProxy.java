package project;

public class DocumentProxy implements Document {
    private String title;
    private String author;
    private String userRole;
    private RealDocument document;
    private final Object lock=new Object();


    public DocumentProxy(String title,String author,String useRole){
        this.title=title;
        this.author=author;
        this.userRole=useRole;
    }

    private boolean isAuth(){
        return userRole.equals("admin")||userRole.equals("editor");
    }
    private void log(String message){
        System.out.println("[LOG] " + userRole + " → " + message);   
    }

    public RealDocument getRealDocument(){
        if(document==null){
            synchronized(lock){
                if(document==null){
                    document=DocumentFactory.getDocument(title, author);
                    // kyuki ye static hai isliye ye bina dependency inject kare bina ho gya 
                    // basically gpt kr aur ache se ans ayega 
                    log("Loaded RealDocument for ");
                }
            }// synchronised lock khtm
        }
        return document;

    };

    @Override
    public void displayContent(){ 
        if(isAuth()){
            log("acceded full content of the document "+title+" ");
            getRealDocument().displayContent();
        }
        else{
            log("Unauthorized access attempt to content: " + title);
            System.out.println("Access Denied: You do not have permission to view the content.");
        }
        
    }
    public void print(){
        if (isAuth()) {
            log("Requested print of document: " + title);
            getRealDocument().print();
        } 
        else {
            log("Unauthorized print attempt: " + title);
            System.out.println("Access Denied: You do not have permission to print the document.");
        }

    };
    public String getMetadata(){
        log("Metadata accessed for: " + title);
        return "Proxy -> " + title + " (loading if needed) "+getRealDocument().getMetadata();
    };
    
}
