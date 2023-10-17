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
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;

/**
 *public class StartFrame extends Frame
 * @author huong
 */
public class StartFrame extends Frame
{
    //Variables
    private JPanel panel;
    private JButton startButton;
    private JButton exitButton;
    private JLabel start_label;

    private void setupPanel() 
    {
        panel = new JPanel(new FlowLayout());
        start_label = new JLabel("GUI Assignment Quiz");
      
        panel.add(start_label);
        panel.setBackground(Color.PINK);
        panel.setPreferredSize(new Dimension(200, 40));
    }//End setupPanel() 

    /**
     *public StartFrame() 
     */
    public StartFrame() 
    {
        startButton = new JButton("Start");
        exitButton = new JButton("Exit");
        
        startButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                start();
            }//End actionPerformed
        });//End startButton.addActionListener
        
        exitButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                exit();
            }//End actionPerformed       
        });//End exitButton.addActionListener

        this.setupFrame();
        this.setupPanel();

        //Add button into Panel and Frame
        panel.add(startButton);
        panel.add(exitButton);
        frame.add(panel);    
    }//End StartFrame() 
    
    /**
     *public void start() 
     */
    public void start() 
    {
        System.out.println("start");
        MainFrame mframe = new MainFrame();
        frame.dispose();
    }//End start()

    /**
     *public void exit() 
     */
    public void exit() 
    {
        System.out.println("exit");
        ExitFrame eframe = new ExitFrame();
        frame.dispose();
    }//End exit() 
}//End StartFrame
