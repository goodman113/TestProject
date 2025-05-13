package entity;

import entity.enums.messageStatus;

import java.util.UUID;

public class Message {
    private final String id = UUID.randomUUID().toString();
    private String FromUserName;
    private String fromUserId;
    private String toUserId;
    private messageStatus status;
    private int score;


    public Message(){

    }


    public Message(String fromUserName, String fromUserId, String toUserId, messageStatus status, int score) {
        FromUserName = fromUserName;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.status = status;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public messageStatus getStatus() {
        return status;
    }

    public void setStatus(messageStatus status) {
        this.status = status;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
