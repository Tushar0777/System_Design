package project;

//import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class DocumentFactory {
    private static final ConcurrentHashMap<String,RealDocument> cache=new ConcurrentHashMap<>();

    public static RealDocument getDocument(String title,String author){

       return cache.computeIfAbsent(author, key->new RealDocument(title, author));

    }

    
}
