package Tinder.Notifications;

import java.util.HashMap;
import java.util.Map;

public class NotificationService {
    private Map<String,Notificationobserver>observers;

    private NotificationService(){
        observers=new HashMap<>();
    }

    private static NotificationService instance;

    public static NotificationService getinstance(){
        if(instance==null){
            instance=new NotificationService();
        }
        return instance;
    }

    public void registerObserver(String userid,Notificationobserver observer){
        observers.put(userid,observer);
    }
    public void removeObserver(String userid){
        if(observers.containsKey(userid)){
            observers.remove(userid);
        }
    }

    public void notifyUser(String userid,String message){
        if(observers.containsKey(userid)){
            observers.get(userid).update(message);
        }
    }

    public void notifyAll(String message){

        for(Map.Entry<String,Notificationobserver> it:observers.entrySet()){
            String userid=it.getKey();
            Notificationobserver observer=it.getValue();
            observer.update(message);
        }
    }
}
