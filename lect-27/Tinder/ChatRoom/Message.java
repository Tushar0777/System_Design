package Tinder.ChatRoom;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {
    private String senderId;
   private String content;
    private long timeStamp;

    public Message(String id,String content){
        this.senderId=id;
        this.content=content;
        timeStamp=System.currentTimeMillis();
    
    }
     public String getSenderId() {
        return senderId;
    }

    public String getContent() {
        return content;
    }

    public long getTimestamp() {
        return timeStamp;
    }

    public String getFormattedTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(timeStamp));
    }
}
