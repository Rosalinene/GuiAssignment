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

package Gui;

//Imports declare
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *public abstract class Frame 
 * @author huong
 */
public abstract class Frame 
{
    /*
     * variable
     */

    protected JFrame frame;

    /*
     *protected void setupFrame()
     */
    protected void setupFrame() 
    {
        frame = new JFrame("Quiz");
        frame.setSize(400,400);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }//End setupFrame()
}//End Frame 
