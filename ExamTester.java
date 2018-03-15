/*
 Class : CS-362
 Name  : Seho Lim
 netID : slim67
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class ExamTester {


    public static void main(String []args) {
        // print out author's information
        System.out.println("\nCS-362 Project 1");
        System.out.println("Name: Seho Lim");
        System.out.println("ACCC account name: slim");
        System.out.println("netID: slim67\n");
        // Create a scanner instances and try to print out.

        // Get the files from here.
        File examFile = new File("src/exam.txt");
        File answerFile = new File("src/student_answer.txt");

        //Path source = Paths.get("exam_data.txt");\
        Scanner examScanner = null;
        try {
            examScanner = new Scanner(examFile);
        }
        //catch the exception
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("print out the exam constructor stuff");
        Exam exam1 = new Exam(examScanner);

        exam1.print();

        /*

        Reorder the exam!

        exam1.reorderQuestions();
        exam1.reorderMCAAnswers(-1);
        exam1.print();
        */
// TODO: 3/14/18  Finish the storing stuff here.
        PrintWriter writer = null;

        try {
            writer = new PrintWriter("src/stored_exam.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        exam1.save(writer);
        System.out.println("The exam is saved. Can be loaded later.");
        System.out.println(exam1.getNumberOfQuestions());


        for(int i=1; i < exam1.getNumberOfQuestions()+1; i++) {
            System.out.println(i);
            exam1.getAnswerFromStudent(i);
        }


        System.out.println("**** Score Report ****");

        System.out.println("Q1: " + exam1.getQuestion(0).getValue());
        System.out.println("Q2: " + exam1.getQuestion(1).getValue());
        System.out.println("Q3: " + exam1.getQuestion(2).getValue());

        //System.out.println("Total Score: " + exam1.getValue());
        PrintWriter answer_writer = null;
        try {
            answer_writer  = new PrintWriter("src/stored_answer.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        exam1.saveStudentAnswer(answer_writer);


        exam1 = null;
        writer = null;
        answer_writer = null;
        examScanner = null;
        examFile = null;

        examFile = new File("src/stored_exam.txt");
        answerFile = new File("src/stored_answer.txt");

        Scanner answerScanner = null;
        try {
            answerScanner = new Scanner(answerFile);
        }
        //catch the exception
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            examScanner = new Scanner(examFile);
        }
        //catch the exception
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("================ reload exam ================");

        exam1 = new Exam(examScanner);
        System.out.println("================ reload answers ================");
        exam1.restoreStudentAnswers(answerScanner);



    }
}
