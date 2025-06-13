package project;

//import Document;

public class RealDocument implements Document {

    private String author;
    private String title;
    private String content;


    public RealDocument(String author,String title){
        this.author=author;
        this.title=title;
        loadContentFromDisk();
        // simulate heavy content from disk 
    }
    void loadContentFromDisk(){
        System.out.println("loading content from disk for " + title +" ..");

        System.out.println("this is the full content of the file "+ content +"-");
        System.out.println("loading complete");
    }

    @Override
   public void displayContent(){
    System.out.println("displaying content from the document");
    System.out.println(content);

    }
    @Override
    public void print(){
        System.out.println("printing the document by the "+author +"of the "+title+" ");

    }
    @Override
    public String getMetadata(){
        return "title "+title +" author "+author+" ";
    }
    
}
