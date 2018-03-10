/*
 Class : CS-362
 text  : Seho Lim
 netID : slim67
 */

import java.util.ArrayList;
import java.util.Collections;

public class Question {
    protected String text; // Question name.
    protected Answer rightAnswer;
    protected Answer studentAnswer;
    protected double maxValue; // Indicate how much this question is currently valued.


    /** Question constructor. It receives the question name.*/
    protected Question(String qName, double val) {
        text = qName;
        maxValue = val;
    }

    public void print() {
        System.out.println(text);

    }

    public void setRightAnswer(Answer ans) {
        rightAnswer = ans;
    }

    public Answer getNewAnswer() {
        /*
        This is an Abstract method. Creates and returns a new answer obj.
         */
        return new Answer();
    }

    public void getAnswerFromStudent() {

    }

    public Answer getRightAnswer() {
        return rightAnswer;
    }

    public double getValue() {
        return 0.0;
    }

    public String getTheQuestion() {
        return text;
    }

    public Answer getStudentAnswer() {
        return studentAnswer;
    }

    public double getMaxValue() {
        return maxValue;
    }


    public void setStudentAnswer(Answer ans) {
        studentAnswer = ans;
    }

}
