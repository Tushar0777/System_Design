package project;

//import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class DocumentFactory {
    private static final ConcurrentHashMap<String,RealDocument> cache=new ConcurrentHashMap<>();

    public static RealDocument getDocument(String title,String author){

       return cache.computeIfAbsent(author, key->{
       System.out.println("[FACTORY] Creating NEW RealDocument for: " + key);
       return new RealDocument(title, author);
    });

    }

    
}
