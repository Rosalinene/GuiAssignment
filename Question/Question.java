
package Question;

//Imports declear
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Question 
{
    private String question;
    private List<String> answers;
    private Boolean[] answerTypes;

    public Question(String question, Boolean[] answerType) 
    {
        this.question = question;
        answers = new ArrayList<>();
        this.answerTypes = answerType;
    }//End constructor

    public void addAnswer(String answer) 
    {
        answers.add(answer);
    }//End addAnswer()

    public String getQuestion() 
    {
        return this.question;
    }//End getQuestion()

    public List<String> getAnswers() 
    {
        return this.answers;
    }//End getAnswers()
    
    public Boolean[] getAnswerTypes() 
    {
        return this.answerTypes;
    }//End getAnswerTypes() 
}//End Question
