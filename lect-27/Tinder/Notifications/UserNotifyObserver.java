package Tinder.Notifications;

public class UserNotifyObserver implements Notificationobserver {
    String userid;

    public UserNotifyObserver(String id){
        this.userid=id;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for user " + userid + ":" + message);
    }
    
}
