package db;

import entity.*;
import entity.Options;
import entity.enums.RoleUser;

import java.util.ArrayList;
import java.util.Scanner;

public class DataSource {
    public static ArrayList<Test> tests = new ArrayList<>();
    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Friends> friends = new ArrayList<>();
    public static ArrayList<Message> messages = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static Scanner strScanner = new Scanner(System.in);
    public static StringBuilder Admin_Results = new StringBuilder();

    public static User currentUser = null;

    public static void sleep() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {

        }
    }

    static {
        users.add(new User( "admin", "admin", "admin", RoleUser.ADMIN));
        users.add(new User( "a", "a", "a", RoleUser.USER));
        users.add(new User( "b", "b", "b", RoleUser.USER));
        users.add(new User( "d", "d", "d", RoleUser.USER));
        users.add(new User( "e", "e", "e", RoleUser.USER));
        users.add(new User( "c", "c", "c", RoleUser.USER));
        users.add(new User( "f", "f", "f", RoleUser.USER));
        tests.add(new Test("What color is sky?", new Options("A", "Green"), new Options("B", "Yellow"), new Options("C", "Blue"), new Options("D", "Red"), "C"));
        tests.add(new Test("Is Ali good?", new Options("A", "Definitely yes"), new Options("B", "Definitely no"), new Options("C", "Probably yes"), new Options("D", "Probably no"), "A"));
        tests.add(new Test("Which of the following is the correct syntax to declare a variable in Java?", new Options("A", "int x = 10;"), new Options("B", "int: x = 10;"), new Options("C", "int = x 10;"), new Options("D", "x = 10;"), "A"));
        tests.add(new Test("Which of the following is the default value of a boolean variable in Java?", new Options("A", "True"), new Options("B", "False"), new Options("C", "null"), new Options("D", "0"), "B"));
        tests.add(new Test("Which of the following is a valid array declaration in Java?", new Options("A", "int[] arr = new int[5];"), new Options("B", "int arr[] = new int(5);"), new Options("C", "array int[5] arr;"), new Options("D", "int arr[5];"), "A"));
        tests.add(new Test("Which of the following is an example of a mutable object?", new Options("A", "Integer"), new Options("B", "String"), new Options("C", "ArrayList"), new Options("D", "Integer and String are both mutable"), "C"));
    }
}
