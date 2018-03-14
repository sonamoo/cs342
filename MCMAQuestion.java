import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MCMAQuestion extends MCQuestion{
    private ArrayList<Answer> studentAnswer; // answer array list.
    private double baseCredit;

    public MCMAQuestion(){
        studentAnswer = null;
        baseCredit = 0;
    }

    public MCMAQuestion(String text, double maxValue, double baseCredit) {
        super();
        this.text = text;
        this.maxValue = maxValue;
        this.studentAnswer = new ArrayList<Answer>();
        this.answers = new ArrayList<MCAnswer>();
    }

    public void save(PrintWriter writer) {
        writer.write(text + "\n");
        char[] answerAlphabet = {'A', 'B', 'C', 'D', 'E'};
        // get the answer and print out.
        int numOfAnswers = answers.size();
        for (int i=0; i < numOfAnswers; i++) {
            writer.write(" " + answerAlphabet[i] + ". ");
            writer.write(" " + answers.get(i).text + "\n");
        }
    }

    public MCMAQuestion(Scanner scanner) {
        super();
        maxValue = Double.parseDouble(scanner.nextLine());
        //System.out.println(maxValue);
        text = scanner.nextLine();
        //System.out.println(text);
        baseCredit = Double.parseDouble(scanner.nextLine());
        studentAnswer = new ArrayList<Answer>();
        answers = new ArrayList<MCAnswer>();
        int numOfexamples = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < numOfexamples; i++) {
            double score = Double.parseDouble(scanner.next());
            String ansText = scanner.nextLine();
            MCMAAnswer ans = new MCMAAnswer(ansText, score);
            //System.out.print(score);
            //System.out.println(ansText);
            //System.out.println(ans);
            //System.out.println(answers);
            answers.add(ans);

        }
    }


}