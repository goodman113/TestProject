package entity;

import java.util.UUID;

public class Friends {
    private final String id = UUID.randomUUID().toString();
    private String userName;
    private String friendName;
    private String friendId;
    private int score;

    public Friends(){

    }

    public Friends(String userName, String friendName, String friendId, int score) {
        this.userName = userName;
        this.friendName = friendName;
        this.friendId = friendId;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "---------------------------------------------\n"+
                "|"+"friendName= " + friendName + " score= " +score+
                "\n---------------------------------------------";
    }
}
