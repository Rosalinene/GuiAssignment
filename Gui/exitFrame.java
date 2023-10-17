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
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;

/**
 *public class ExitFrame extends Frame
 * @author huong
 */
public class ExitFrame extends Frame
{
    //  Variables
    private JPanel panel;
    private JLabel label;
    private JButton confirmButton;

    private void setupPanel() 
    {
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(Color.PINK);
    }//End setupPanel()

    private void setupLabel() 
    {
        label = new JLabel("Thank you for your time!");
    }//End setupLabel() 
    
    /**
     *public ExitFrame()
     */
    public ExitFrame()
    {
        this.setupFrame();
        this.setupLabel();
        this.setupPanel();
        this.confirmButton = new JButton("OK");
        
        this.confirmButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                exitApplication();
            }//End actionPerformed
        });//End confirmButton.addActionListener
        
        //Add label and button into ExitFrame
        panel.add(label);
        panel.add(confirmButton);
        frame.add(panel);
    }//End exitFrame()
    
    /**
     *public void exitApplication() 
     */
    public void exitApplication() 
    {
        System.exit(0);
    }//End exitApplication()
}//End class exitFrame
