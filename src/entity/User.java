package entity;

import entity.enums.RoleUser;

import java.util.UUID;

public class User {
    private final String id = UUID.randomUUID().toString();
    private String nickName;
    private String email;
    private String password;
    private RoleUser role;
    private StringBuilder history = new StringBuilder();
    private int score;
    private long solveTime;
    private int testCount;
    private int messageCount;

    public User(String name, String email, String password, RoleUser role) {
        this.nickName = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public void setHistory(StringBuilder history) {
        this.history = history;
    }

    public long getSolveTime() {
        return solveTime;
    }

    public void setSolveTime(long solveTime) {
        this.solveTime = solveTime;
    }

    public int getScore() {
        return score;
    }

    public StringBuilder getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history.append(history).append('\n');
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleUser getRole() {
        return role;
    }

    public void setRole(RoleUser role) {
        this.role = role;
    }

    public int getTestCount() {
        return testCount;
    }

    public void setTestCount(int testCount) {
        this.testCount = testCount;
    }

    public int getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(int messageCount) {
        this.messageCount = messageCount;
    }

    @Override
    public String toString() {
        long seconds = solveTime / 1000;
        long remainingMillis = solveTime % 1000;

        return "User{" +
                "nickname='" + nickName + '\'' +
                ", score=" + score +
                ", solve time=" + seconds + " seconds " + remainingMillis + " milliseconds" +
                '}';
    }
}
