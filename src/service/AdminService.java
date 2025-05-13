package service;

import entity.*;

import static db.DataSource.*;

public class AdminService {
    public static void service() {
        while (true) {
            System.out.println("""
                    0 exit
                    1 show test
                    2 add test
                    3 remove test
                    4 edit test
                    5 results
                    """);
            switch (strScanner.nextLine()) {
                case "0" -> {
                    return;
                }
                case "1" -> showTest();
                case "2" -> addTest();
                case "3" -> removeTest();
                case "4" -> editTest();
                case "5" -> System.out.println(Admin_Results);
            }
        }
    }

    private static void showTest() {
        for (Test test : tests) {
            System.out.println(test.getQuestion() + "\t" + "ID= " + test.getTestID());
        }
    }


    private static void editTest() {
        showTest();

        System.out.println("which test you want to edit?(enter ID)");
        String removeId = strScanner.nextLine();
        Test test = null;
        boolean check = false;
        for (Test test1 : tests) {
            if (test1.getTestID().equals(removeId)) {
                check = true;
                test = test1;
            }
        }
        if (!check) {
            System.out.println("Icorrect ID");
            return;
        }
        System.out.println(" ");
        while (true) {
            System.out.println("""
                    0 exit
                    1 edit question
                    2 edit option's answer
                    3 edit correct option
                    """);
            switch (strScanner.nextLine()) {
                case "0" -> {
                    return;
                }
                case "1" -> {
                    System.out.println("enter the new question");
                    String newQuest = strScanner.nextLine();
                    for (Test test1 : tests) {
                        if (test1.getQuestion().equals(newQuest)) {
                            System.out.println("this question already exists!");
                            return;
                        }
                    }
                    test.setQuestion(newQuest);
                    System.out.println("test was edited successfully!");
                }
                case "2" -> {
                    showOptions(test);
                    System.out.println("enter an option for alternation");
                    switch (strScanner.nextLine().toUpperCase()) {
                        case "A" -> {
                            System.out.println("enter new option A");
                            String op = strScanner.nextLine();
                            if (NoMoreOfOption(op, test)) {
                                return;
                            }
                            test.getA().setAnswer(op);
                            System.out.println("Option was changed");
                        }
                        case "B" -> {
                            System.out.println("enter new option B");
                            String op = strScanner.nextLine();
                            if (NoMoreOfOption(op, test)) {
                                return;
                            }
                            test.getB().setAnswer(op);
                            System.out.println("Option was changed");
                        }
                        case "C" -> {
                            System.out.println("enter new option C");
                            String op = strScanner.nextLine();
                            if (NoMoreOfOption(op, test)) {
                                return;
                            }
                            test.getB().setAnswer(op);
                            System.out.println("Option was changed");
                        }
                        case "D" -> {
                            System.out.println("enter new option D");

                            String op = strScanner.nextLine();
                            if (NoMoreOfOption(op, test)) {
                                return;
                            }
                            test.getD().setAnswer(op);
                            System.out.println("Option was changed");
                        }
                        default -> {
                            System.out.println("Invalid input!");
                            return;
                        }

                    }
                }
                case "3" -> {
                    showOptions(test);
                    System.out.println("enter the correct option(A/B/C/D): ");
                    String correctOption = "";
                    switch (strScanner.nextLine()) {
                        case "A" -> {
                            correctOption = "A";
                        }
                        case "B" -> {
                            correctOption = "B";
                        }
                        case "C" -> {
                            correctOption = "C";
                        }
                        case "D" -> {
                            correctOption = "D";
                        }
                        default -> {
                            System.out.println("Invalid input!");
                            return;
                        }
                    }
                    test.setCorrectAnswer(correctOption);
                    System.out.println("the change was successful");
                }
            }
        }
    }

    private static void showOptions(Test test) {
        System.out.println(test.getA());
        System.out.println(test.getB());
        System.out.println(test.getC());
        System.out.println(test.getD());
        System.out.println("correct answer is: "+ test.getCorrectAnswer());
    }

    private static boolean NoMoreOfOption(String op, Test test) {
        if (op.equals(test.getA().getAnswer()) || op.equals(test.getB().getAnswer()) || op.equals(test.getC().getAnswer()) || op.equals(test.getD().getAnswer())) {
            System.out.println("you already have this option");
            return true;
        }
        return false;
    }

    private static void removeTest() {
        showTest();

        System.out.println("which test you want to remove?(enter ID)");
        String removeId = strScanner.nextLine();
        for (Test test : tests) {
            if (test.getTestID().equals(removeId)) {
                tests.remove(test);
                System.out.println("test was removed successfully!");
                return;
            }
        }
        System.out.println("Incorrect ID");
    }

    private static void addTest() {
        System.out.println("enter the question: ");
        String question = strScanner.nextLine();
        for (Test test : tests) {
            if (test.getQuestion().equals(question)) {
                System.out.println("this question already exists!");
                return;
            }
        }
        System.out.println("enter the option A: ");
        String OpA = strScanner.nextLine();
        System.out.println("enter the option B: ");
        String OpB = strScanner.nextLine();
        System.out.println("enter the option C: ");
        String OpC = strScanner.nextLine();
        System.out.println("enter the option D: ");
        String OpD = strScanner.nextLine();
        System.out.println("enter the correct option(A/B/C/D): ");
        String correctOption = "";
        switch (strScanner.nextLine()) {
            case "A" -> {
                correctOption = "A";
            }
            case "B" -> {
                correctOption = "B";
            }
            case "C" -> {
                correctOption = "C";
            }
            case "D" -> {
                correctOption = "D";
            }
            default -> {
                System.out.println("Invalid input!");
                return;
            }
        }
        Test test = new Test(question, new Options("A", OpA), new Options("B", OpB), new Options("C", OpC), new Options("D", OpD), correctOption);
        if (test.getA().getAnswer().equals(test.getB().getAnswer())||test.getA().getAnswer().equals(test.getC().getAnswer())||test.getA().getAnswer().equals(test.getD().getAnswer())
        ||test.getB().getAnswer().equals(test.getC().getAnswer())||test.getB().getAnswer().equals(test.getD().getAnswer())||test.getC().getAnswer().equals(test.getD().getAnswer())){
            System.out.println("there cannot be duplicate answers");
            return;
        }
        System.out.println("test was added successfully!");
        tests.add(test);
    }
}
