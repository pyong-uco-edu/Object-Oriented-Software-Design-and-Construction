package model;

import java.util.ArrayList;

public class QuestionBank {
    public static final ArrayList<Question> database = new ArrayList<>();

    static {
        database.add(new Question("Who is the inventor of Java language?", "James Gosling"));
        database.add(new Question("In what city of UCO located?", "Edmond"));
        var c1 = new ChoiceQuestion("What is the capital city of Oklahoma?", "2");
        c1.addChoice("Norman");
        c1.addChoice("Oklahoma City");
        c1.addChoice("Edmond");
        c1.addChoice("Tulsa");
        database.add(c1);
        var c2 = new ChoiceQuestion("Which of the following is not a Java keyword?", "4");
        c2.addChoice("int");
        c2.addChoice("for");
        c2.addChoice("instanceof");
        c2.addChoice("String");
        database.add(c2);
    }
}
