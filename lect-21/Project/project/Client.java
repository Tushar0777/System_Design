package project;

public class Client {
    public static void main(String[] args) {
        Document doc1=new DocumentProxy("Serets.pdf", "Boss","admin");
       // doc1.getMetadata();
        doc1.displayContent();
        System.out.println("-----------------------");
        doc1.getMetadata();
         System.out.println("-----------------------");
         doc1.print();
          System.out.println("-----------------------");


        Document doc2=new DocumentProxy("secrets.pdf", "Boss", "user");
        doc2.getMetadata();
        System.out.println("-----------------------");

        doc2.displayContent();
        System.out.println("-----------------------");

    }
    
}
