package Tinder.ChatRoom;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private String id;
    List<String>participants;
    List<Message>messages;

    public ChatRoom(String roomid,String userid1,String userid2){
        this.id=roomid;
        participants=new ArrayList<>();
        participants.add(userid1);
        participants.add(userid2);
        messages=new ArrayList<>();
    }
    public String getId(){
        return id;
    }
    public void addMessage(String senderId,String content){
        Message msg=new Message(senderId,content);
        messages.add(msg);
    }
    public boolean hasParticipant(String userId) {
        return participants.contains(userId);
    }
     public List<Message> getMessages() {
        return messages;
    }

    public List<String> getParticipants() {
        return participants;
    }

    public void displayChat(){
          System.out.println("===== Chat Room: " + id + " =====");
        for (Message msg : messages) {
            System.out.println("[" + msg.getFormattedTime() + "] " + msg.getSenderId() + ": " + msg.getContent());
        }
        System.out.println("=========================");
    }


}
