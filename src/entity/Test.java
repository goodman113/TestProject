package entity;

import entity.*;

import java.util.UUID;

public class Test {
    private final String testID= UUID.randomUUID().toString();
    private Options A;
    private Options B;
    private Options C;
    private Options D;
    private String question;
    private String CorrectAnswer;

    public Test( String question,Options a, Options b, Options c, Options d, String correctAnswer) {
        this.question = question;
        A = a;
        B = b;
        C = c;
        D = d;
        CorrectAnswer = correctAnswer;
    }

    public String getTestID() {
        return testID;
    }

    public Options getA() {
        return A;
    }

    public void setA(Options a) {
        A = a;
    }

    public Options getB() {
        return B;
    }

    public void setB(Options b) {
        B = b;
    }

    public Options getC() {
        return C;
    }

    public void setC(Options c) {
        C = c;
    }

    public Options getD() {
        return D;
    }

    public void setD(Options d) {
        D = d;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        CorrectAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return
                question +"\n"+
                        A +"\n"+
                        B +"\n"+
                        C +"\n"+
                        D ;
    }

}
