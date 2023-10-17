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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import Question.Question;
import Question.Quiz;
import java.util.Collections;

/**
 *public class MainFrame  extends Frame 
 * @author huong
 */
public class MainFrame  extends Frame 
{
    //Variables
    private JPanel main_panel;
    private JPanel question_panel;
    private JPanel answer_panel;
    private JPanel total_correct_panel;
    private Quiz mquiz;
    private JLabel question_label;
    private JLabel total_correct_label;
    private JLabel error_label;
    private ButtonGroup button_group;
    private JRadioButton a, b, c, d;
    private JButton submit_button;
    private int current_question_index;
    private int current_answer;
    private ArrayList<Question> questions;
    
    private void setupPanel() 
    {
        main_panel = new JPanel(new FlowLayout());
        question_panel = new JPanel(new FlowLayout());
        answer_panel = new JPanel(new FlowLayout());
        total_correct_panel = new JPanel(new FlowLayout());
        
        main_panel.setBackground(Color.PINK);
        main_panel.setPreferredSize(new Dimension(200, 40));
        question_panel.setBackground(Color.PINK);
        answer_panel.setBackground(Color.PINK);
        total_correct_panel.setBackground(Color.PINK);
    }//End setupPanel()
    
    private void setupQuestionLabel(String question) 
    {
        if (current_question_index >= questions.size()) 
        {
            question_label.setText("All questions answered!");
            question_panel.add(question_label);
            return;
        }//End if loop
        question_label.setText("Question " + (current_question_index+1) +": " + question);
        question_panel.add(question_label);
    }//End 

    private void setupTotalCorrectLabel() 
    {
        total_correct_label.setText("Total correct: " + mquiz.getTotalCorrect());
        total_correct_panel.add(total_correct_label);
    }//End setupQuestionLabel

    private void loadQuestion() 
    {
        answer_panel.removeAll();
        System.out.println("current question index: " + current_question_index);
        if (current_question_index >= questions.size()) 
        {
            setupQuestionLabel(null);
            setupTotalCorrectLabel();
            frame.revalidate();
            frame.repaint();
            return;
        }//End if loop
        Question question = questions.get(current_question_index);
        setupQuestionLabel(question.getQuestion());
        setupAnswers(question.getOptions(), question.getAnswer());
        setupTotalCorrectLabel();
        frame.revalidate();
        frame.repaint();
    }//End loadQuestion()

    private void setupAnswers(ArrayList<Integer> options, int right_answer) 
    {
        submit_button = new JButton("Submit");
        Collections.shuffle(options);
        a = new JRadioButton("A. " + options.get(0));
        b = new JRadioButton("B. " + options.get(1));
        c = new JRadioButton("C. " + options.get(2));
        d = new JRadioButton("D. " + options.get(3));
        
        a.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                current_answer = options.get(0);
            } //End actionPerformed
        });//End a.addActionListener

        b.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                current_answer = options.get(1);
            } //End actionPerformed
        });//End b.addActionListener

        c.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                current_answer = options.get(2);
            } //End actionPerformed
        });//End c.addActionListener

        d.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                current_answer = options.get(3);
            } //End actionPerformed
        });//End d.addActionListener

        submit_button.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                System.out.println("Answer: " + current_answer + " Right answer: " + right_answer);
                if (current_answer == -1)
                {
                    total_correct_panel.add(error_label);
                    frame.revalidate();
                    frame.repaint();
                    return;
                }//End if loop
                else if (current_answer == right_answer) 
                {
                    mquiz.increaseTotalCorrect();   
                } //End else if           
                total_correct_panel.remove(error_label);
                current_question_index++;
                current_answer = -1;
                loadQuestion();
            }////End actionPerformed
        });//End submit_button.addActionListener

        //Add answers into panel and button group
        button_group.add(a);
        button_group.add(b);
        button_group.add(c);
        button_group.add(d);
        answer_panel.add(a);
        answer_panel.add(b);
        answer_panel.add(c);
        answer_panel.add(d);
        answer_panel.add(submit_button);
    }//End setupAnswers
    
    /**
     *public MainFrame()
     */
    public MainFrame() 
    {
        mquiz = new Quiz();
        question_label = new JLabel("Question: ");
        error_label = new JLabel ("Error! Please choose your answer.");
        total_correct_label = new JLabel("Total correct: ");
        button_group = new ButtonGroup();
        submit_button = new JButton("Submit");
        current_question_index = 0;
        current_answer = -1;
        
        this.setupFrame();
        this.setupPanel();
        main_panel.add(question_panel);
        main_panel.add(answer_panel);
        main_panel.add(total_correct_panel);
        frame.add(main_panel); 
        questions = mquiz.giveQuiz(10);
        loadQuestion();
    }//End constructor MainFrame() 
}//End class MainFrame()