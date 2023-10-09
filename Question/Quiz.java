
package Question;

//Imports declear
import Gui.exitFrame;
import Gui.mainFrame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JLabel;

public abstract class Quiz 
{
    private final List<Question> questions;
    public int totalCorrect;

    public Quiz() 
    {
        questions = new ArrayList<>();
    }//End quiz

    public void addQuestion(Question question) 
    {
        if (questions.size() < 25) 
        {
            questions.add(question);
        } //End if
        else 
        {
            System.out.println("The quiz can only have 25 questions.");
        }//End else
    }//End addQuestion()
    
    public void giveQuiz(JLabel cl1, JLabel cl2, JLabel cl3, JLabel cl4, JLabel ql, mainFrame mf) 
    {
        totalCorrect = 0;
        
        Collections.shuffle(questions);
        
        for (int i = 0; i < questions.size() - 15; i++) 
        {
            Question question = questions.get(i);
            ql.setText("Question " + (i + 1) + ": " + question.getQuestion());
            List<String> answers = question.getAnswers();
            
            cl1.setText(answers.get(0));
            cl2.setText(answers.get(1));
            cl3.setText(answers.get(2));
            cl4.setText(answers.get(3));
            
            System.out.println();
            Boolean[] answerTypes = question.getAnswerTypes();
            mf.answers = answerTypes;
            mf.answered = false;
            
            while(mf.answered == false)
            {
            }//End while loop
        }//End for loop
        System.out.println("Your total score is:" + totalCorrect); 
        
        exitFrame ef = new exitFrame();
    }//End giveQuiz()
}//End Quiz
