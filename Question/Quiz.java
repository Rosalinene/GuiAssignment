
package Question;

//Imports declear
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public abstract class Quiz 
{
    private List<Question> questions;
    private int totalCorrect;

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
    
    public void giveQuiz() 
    {
        Scanner myObj = new Scanner(System.in);
        totalCorrect = 0;
        
        // Randomize questions list
        Collections.shuffle(questions);
        
        for (int i = 0; i < questions.size() - 15; i++) 
        {
            Question question = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + question.getQuestion());
            System.out.println("Possible Answers:");
            List<String> answers = question.getAnswers();
            for (int j = 0; j < answers.size(); j++) 
            {
                System.out.println((char)('A' + j) + ": " + answers.get(j));
            }//End for loop
            
            System.out.println();
            String choice = myObj.nextLine();
            choice.toUpperCase();
            char c = choice.charAt(0);
            Boolean[] answerTypes = question.getAnswerTypes();
            
            switch (c) 
            {
                case 'A':
                    if(answerTypes[0] == true)
                    {
                        totalCorrect += 1;
                        System.out.println("Correct!");
                    }//End if case A
                    else
                    {
                        System.out.println("Wrong!");
                    }//End else case A
                    break;
                case 'B':
                    if(answerTypes[1] == true)
                    {
                        totalCorrect += 1;
                        System.out.println("Correct!");
                    }//End if case B
                    else
                    {
                        System.out.println("Wrong!");
                    }//End else case B
                    break;
                case 'C':
                    if(answerTypes[2] == true)
                    {
                        totalCorrect += 1;
                        System.out.println("Correct!");
                    }//End if case C
                    else
                    {
                        System.out.println("Wrong!");
                    }//End else case C
                    break;
                case 'D':
                    if(answerTypes[3] == true)
                    {
                        totalCorrect += 1;
                        System.out.println("Correct!");
                    }//End if case D
                    else
                    {
                        System.out.println("Wrong!");
                    }//End else case D
                    break;
                default:
                System.out.println("Please choose A, B, C, or D");
            }//End switch loop
        }//End for loop
        System.out.println("Your total score is:" + totalCorrect); 
    }//End giveQuiz()
}//End Quiz
