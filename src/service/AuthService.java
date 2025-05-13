package service;

import entity.*;
import entity.enums.RoleUser;

import java.util.Objects;

import static db.DataSource.*;

public class AuthService {
    public static void service(){
        while (true){
            System.out.println("""
                    1 sign up
                    2 sign in
                    """);
            switch (strScanner.nextLine()){
                case "1"->{
                    String name = checkNickNameForUniqueness();
                    System.out.println("enter email");
                    String email = strScanner.nextLine();
                    System.out.println("enter password");
                    String password = strScanner.nextLine();
                    users.add(new User(name,email,password, RoleUser.USER));
                    System.out.println("User was added!");

                }
                case "2"->{
                    System.out.println("enter email");
                    String email = strScanner.nextLine();
                    System.out.println("enter password");
                    String password = strScanner.nextLine();
                    if (email.equals("admin")&& password.equals("admin")){
                        AdminService.service();
                    }
                    for(int i=1;i<users.size();i++){
                        if (users.get(i).getEmail().equals(email)&& users.get(i).getPassword().equals(password)){
                            currentUser = users.get(i);
                            UserService.service();
                        }
                    }
                }
            }
        }
    }

    private static String checkNickNameForUniqueness() {
        System.out.println("enter nickname");
        String name = strScanner.nextLine();
        for (int i = 0; i < users.size(); i++) {
            if (Objects.equals(name, users.get(i).getNickName())){
                System.out.println("such nickName already exists buddy!");
                checkNickNameForUniqueness();
            }
        }
        return name;
    }
}
