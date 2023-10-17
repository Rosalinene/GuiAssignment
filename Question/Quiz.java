/*
* @author Huong Pham
 * Course: CSC 112-301 Fund of computing II
 * Assignment: GuiAssignment1
 * Description: Create a program with a GUI. Which gives a quiz.
There should be a class called Question. This class should maintain the question, 4 possible answers, which answer is the correct choice.
There should be a class called Quiz which has a list of 25 question objects. An there should be a Add method which adds a Question Object to the Quizz. The Quiz can be populated by main. A method called GiveQuiz which presents the question to the user in a text area component.
The answer choices should be radio buttons. The Quiz will keep track of the number of question the user gets correct. Quiz should provide 10 random question from the list of 25.
After the 10 questions it should display the user grade. There will need to be a button to start the quiz, and a button to submit the answer the user selects.
The submit button should not be available until the quiz starts. The final grade can be displayed in a label on the form, should not just be on the screen the user should know what that number is.
Looking for a good clean interface using layout managers.
*/

package Question;

//Imports declare
import java.util.ArrayList;

/**
 *public class Quiz 
 * @author huong
 */
public class Quiz 
{
    private final QuestionBank question_bank;
    private int totalCorrect;

    /**
     * public Quiz()
     */
    public Quiz() 
    {
        this.question_bank = new QuestionBank(25);
    }//End Quiz()
    
    /**
     *public giveQuiz
     * @param num_questions
     * @return
     */
    public ArrayList<Question> giveQuiz(int num_questions) 
    {
        totalCorrect = 0;
        return this.question_bank.getRandomQuestionsFromBank(10);
    }//End giveQuiz()

    /**
     * public int getTotalCorrect() 
     * @return
     */
    public int getTotalCorrect() 
    {
        return totalCorrect;
    }//End getTotalCorrect() 

    /**
     *public void increaseTotalCorrect() 
     */
    public void increaseTotalCorrect() 
    {
        totalCorrect++;
    }//End increaseTotalCorrect() 
}//End Quiz