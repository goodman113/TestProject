package service;

import entity.*;
import entity.enums.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import static db.DataSource.*;

public class UserService {
    public static void service() {
        while (true) {
            if (currentUser.getMessageCount()>0){
            System.out.printf("""
                    0 exit
                    1 begin test
                    2 leader board
                    3 add friend
                    4 see massages %d
                    5 see friends
                    6 history
                    """,currentUser.getMessageCount());
            }
            else{
            System.out.println("""
                    0 exit
                    1 begin test
                    2 leader board
                    3 add friend
                    4 see massages (no massages)
                    5 see friends
                    6 history
                    """);
            }
            switch (strScanner.nextLine()) {
                case "0" -> {
                    return;
                }
                case "1" -> beginTest();
                case "2" -> leaderBoard();
                case "3" -> addFriend();
                case "4" -> seeMassages();
                case "5" -> seeFriends();
                case "6" -> System.out.println(currentUser.getHistory());
            }
        }
    }

    private static void seeFriends() {
        int count=0;
        for(Friends friend: friends){
            if (friend.getUserName().equals(currentUser.getNickName())){
                count++;
            }
        }
        if (count==0){
            System.out.println("you have no friends");
            return;
        }

        for(Friends friend: friends){
            if (friend.getUserName().equals(currentUser.getNickName())){
                System.out.println(friend);
            }
        }

    }

    private static void seeMassages() {
        int count =0;
        for (Message message: messages){
            if (currentUser.getId().equals(message.getToUserId())){
                count++;
            }
        }
        if (count==0){
            System.out.println("you have 0 messages");
            return;
        }
        Iterator<Message> iterator = messages.iterator();
        while (iterator.hasNext()) {
            Message message = iterator.next();
            if (currentUser.getId().equals(message.getToUserId()) && message.getStatus().equals(messageStatus.PENDING)) {
                System.out.println(message.getFromUserName() + " wants to be friends with you, will you accept it?");
                System.out.println("""
                1 yes
                2 no
                """);
                switch (strScanner.nextLine()) {
                    case "1" -> {
                        message.setStatus(messageStatus.SUCCESSFUL);
                        friends.add(new Friends(message.getFromUserName(), currentUser.getNickName(), currentUser.getId(), message.getScore()));
                        friends.add(new Friends(currentUser.getNickName(), message.getFromUserName(), currentUser.getId(), currentUser.getScore()));
                        System.out.println("now " + message.getFromUserName() + " is added on your friend list");
                        iterator.remove();
                    }
                    case "2" -> {
                        message.setStatus(messageStatus.CANCELED);
                        System.out.println("you canceled the request from " + message.getFromUserName());
                        iterator.remove();
                    }
                }
                currentUser.setMessageCount(currentUser.getMessageCount() - 1);
            }
        }

    }

    private static void addFriend() {
        System.out.println("enter nickname: ");
        String nickName = strScanner.nextLine();
        if (nickName.equals(currentUser.getNickName())){
            System.out.println("you can't add yourself!");
            return;
        }
        User friendUser = null;
        boolean check=false;
        for(User user:users){
            if (user.getNickName().equals(nickName)){
                check=true;
                friendUser = user;
                break;
            }
        }
        for (Friends friend: friends){
            if (friend.getUserName().equals(currentUser.getNickName())&&friend.getFriendName().equals(nickName)){
                System.out.println("this user already in your friend list");
                return;
            }
        }
        if (!check){
            System.out.println("no user was found with this nickname");
            return;
        }
        messages.add(new Message(currentUser.getNickName(),currentUser.getId(),friendUser.getId(),messageStatus.PENDING, currentUser.getScore()));
        System.out.println("request was sent, wait until "+friendUser.getNickName()+" accepts");
       friendUser.setMessageCount(friendUser.getMessageCount()+1);

    }

    private static void leaderBoard() {
        ArrayList<User> u = new ArrayList<>(users);
        int count = 1;
        u.remove(0);
        while (!u.isEmpty()) {
            User user = findUserWithHighRating(u);
            System.out.println("Rank "+count+" = "+user);
            u.remove(user);
            count++;
        }
    }

    private static User findUserWithHighRating(ArrayList<User> u) {
        int max = 0;
        User user = null;
        for (User value : u) {
            if (max <= value.getScore()) {
                max = value.getScore();
                user = value;
            }
        }
        return user;
    }

    private static void beginTest() {
        int score = 0;
        Collections.shuffle(tests);
        System.out.println("now, let's begin the test!!");
        sleep();
        System.out.println("3...");
        sleep();
        System.out.println("2...");
        sleep();
        System.out.println("1...");
        System.out.println("Your time starts now!!");
        long startTime = System.nanoTime();
        int testCount = tests.size() >= 5 ? 5 : tests.size();
        for (int i = 0; i < testCount; i++) {
            Test test = tests.get(i);
            System.out.println("choose the correct option.");
            System.out.println(test);
            String answer = strScanner.nextLine().toUpperCase();
            if (answer.equals(test.getCorrectAnswer())) {
                System.out.println("Correct✅✅");
                currentUser.setScore(currentUser.getScore() + 2);
                score += 2;
                if (i != 4) {
                    System.out.println("keep it up!");
                }
            } else {
                System.out.println("Incorrect❌❌");
            }
        }
        long endTime = System.nanoTime();
        long durationNano = endTime - startTime;
        long millis = durationNano / 1_000_000;
        long seconds = millis / 1000;
        long remainingMillis = millis % 1000;
        System.out.printf("Spent time: %d seconds %d milliseconds\n", seconds, remainingMillis);
        long solvetime = millis;
        if (currentUser.getSolveTime()==0||currentUser.getSolveTime()>solvetime){
            currentUser.setSolveTime(solvetime);
            System.out.println("congratulations on improving your result time!!");
        }
        System.out.println("you scored " + score + " out of " + testCount * 2);
        currentUser.setHistory("you scored " + score + " out of " + testCount * 2);
        Admin_Results.append(currentUser.getNickName()).append(" scored ").append(score).append(" out of ").append(testCount * 2).append('\n');

    }
}