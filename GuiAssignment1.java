package guiassignment1;

//Imports declear
import Question.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GuiAssignment1 
{
    
    
    public static void main(String args[]) 
    {   
        Quiz quiz = new Quiz() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            { 
            }
        };
        

        // Generate 25 random questions with 4 random answers each
        for (int i = 1; i <= 25; i++) 
        {
            int x = getRandomNumber();
            int y = getRandomNumber();
            int answer = x+y;

            Integer[] intArray = { getRandomNumber(), answer, getRandomNumber(), getRandomNumber()};
            Boolean[] answerArray = { false, false, false, false};            

            List<Integer> intList = Arrays.asList(intArray);

            Collections.shuffle(intList);
            for (int n = 0; n < 4; n++)
            {
                if ((x + y == intList.get(n)))
                {
                    answerArray[n] = true;
                }//End if
                else 
                {
                    answerArray[n] = false;
                }//End else
            }//End for loop

            Question question = new Question("Question " + i + ": What is " + x + " + " + y + "?", answerArray);
            question.addAnswer("A. " + (intList.get(0)));
            question.addAnswer("B. " + (intList.get(1)));
            question.addAnswer("C. " + (intList.get(2)));
            question.addAnswer("D. " + (intList.get(3)));
            quiz.addQuestion(question);
        }//End for loop 
        quiz.giveQuiz();
    }//End main
    
    // Helper method to generate a random number between 1 and 10
    private static int getRandomNumber() 
    {
        Random rand = new Random();
        return rand.nextInt(10) + 1;
    }//End getRandomNumber()  
   
}//End GuiAssignment1 
