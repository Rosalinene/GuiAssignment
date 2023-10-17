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
import java.util.Collections;
import java.util.Random;

/**
 *public class QuestionBank 
 * @author huong
 */
public class QuestionBank 
{
    private int n_questions;
    private ArrayList<Question> questions;
    
    /**
     *public QuestionBank(int n_questions)
     * @param n_questions
     */
    public QuestionBank(int n_questions) 
    {
        this.n_questions = n_questions;
        this.generateQuestionList();
    }//End QuestionBank()

    private void generateQuestionList() 
    {
        this.questions = new ArrayList<Question>();
        for (int i = 0; i < this.n_questions; i++) 
        {
            Question question = this.generateRandomQuestion();
            this.questions.add(question);
        }//End for loop
    }//End generateQuestionList()

    private Question generateRandomQuestion() 
    {
        //Create random numbers for questions and answers
        Random rand = new Random();
        int x = rand.nextInt(10) + 1;
        int y = rand.nextInt(10) + 1;
        int right_answer = x + y;
        int wrong_answer1 = right_answer + rand.nextInt(5) + 1;
        int wrong_answer2 = right_answer + rand.nextInt(5) + 1;
        int wrong_answer3 = right_answer + rand.nextInt(5) + 1;

        //Add answers into options
        ArrayList <Integer> options = new ArrayList <Integer>();
        options.add(right_answer);
        options.add(wrong_answer1);
        options.add(wrong_answer2);
        options.add(wrong_answer3);
        
        return new Question("What is " + x + " + " + y + "?", right_answer, options);
    }//End generateRandomQuestion()

    /**
     *public ArrayList<Question> getRandomQuestionsFromBank(int n_questions_) 
     * @param n_questions_
     * @return
     */
    public ArrayList<Question> getRandomQuestionsFromBank(int n_questions_) 
    {
        Collections.shuffle(this.questions);
        ArrayList<Question> sample_questions = new ArrayList<Question>();
        for (int i = 0; i < n_questions_; i++) 
        {
            sample_questions.add(this.questions.get(i));
        }//End for loop
        return sample_questions;
    }//End getRandomQuestionsFromBank
}//End QuestionBank