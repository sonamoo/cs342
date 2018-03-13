/*
 Class : CS-362
 Name  : Seho Lim
 netID : slim67
 */

public class SAAnswer extends Answer {

    private String text;

    public SAAnswer(String s) {
        text = s;
    }
    
    public void print() {

    }

    public String getText() {
        return text;
    }

    /** Abstract method for childeren's double getCredit methods. */
    public double getCredit(Answer rightAnswer) {

        if (getText().equals(((SAAnswer) rightAnswer).getText())) {
            return 1;
        }
        return 0.0;
    }
}