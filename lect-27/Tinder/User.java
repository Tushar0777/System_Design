package Tinder;

import java.util.HashMap;
import java.util.Map;

import Tinder.Notifications.NotificationService;
import Tinder.Notifications.Notificationobserver;
import Tinder.Notifications.UserNotifyObserver;

enum SwipeAction {
    LEFT,  // Dislike
    RIGHT  // Like
}
public class User{
   private String id;
    private UserProfile profile;
    private Preference preference;
    private Map<String, SwipeAction> swipeHistory;    // userId -> action
    private Notificationobserver notificationObserver;

     public User(String userId) {
        id = userId;
        profile = new UserProfile();
        preference = new Preference();
        swipeHistory = new HashMap<>();
        notificationObserver = new UserNotifyObserver(userId);
        NotificationService.getinstance().registerObserver(userId, notificationObserver);
    }
    public String getId() {
        return id;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public Preference getPreference() {
        return preference;
    }
     public void swipe(String otherUserId, SwipeAction action) {
        swipeHistory.put(otherUserId, action);
    }
       public boolean hasLiked(String otherUserId) {
        return swipeHistory.containsKey(otherUserId) && swipeHistory.get(otherUserId) == SwipeAction.RIGHT;
    }

    public boolean hasDisliked(String otherUserId) {
        return swipeHistory.containsKey(otherUserId) && swipeHistory.get(otherUserId) == SwipeAction.LEFT;
    }

    public boolean hasInteractedWith(String otherUserId) {
        return swipeHistory.containsKey(otherUserId);
    }

    public void displayProfile() {  // Principle of least knowledge
        profile.display();
    }


}