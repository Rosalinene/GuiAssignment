
package Gui;

import Question.Question;
import Question.Quiz;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public final class mainFrame extends JPanel
{
    private final JFrame frame1;
    private final JPanel panel2;
    private final JButton A, B, C, D;
    private final JLabel questionLabel, choiceLabel1, choiceLabel2, choiceLabel3, choiceLabel4, totalLabel;
    public Boolean[] answers;
    public int totalCorrect;
    public Boolean answered;
    public Quiz quiz;
    public mainFrame thismf;
    
    public mainFrame()
    {
        frame1 = new JFrame();
        frame1.setTitle("Assignment 1 Quiz");
        frame1.setSize(400,400);
        frame1.setResizable(false);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame1.setVisible(true);
        
        questionLabel = new JLabel("Question");
        choiceLabel1 = new JLabel("Choice A");
        choiceLabel2 = new JLabel("Choice B");
        choiceLabel3 = new JLabel("Choice C");
        choiceLabel4 = new JLabel("Choice D");
        totalLabel = new JLabel("");
        
        A = new JButton("A");
        B = new JButton("B");
        C = new JButton("C");
        D = new JButton("D");
        
        mainFrame.ButtonListener listener = new mainFrame.ButtonListener();
        A.addActionListener(listener);
        B.addActionListener(listener);
        C.addActionListener(listener);
        D.addActionListener(listener);
        
        panel2 = new JPanel();
        panel2.add(questionLabel);
        panel2.add(choiceLabel1);
        panel2.add(choiceLabel2);
        panel2.add(choiceLabel3);
        panel2.add(choiceLabel4);
        panel2.add(totalLabel);
        panel2.add(A);
        panel2.add(B);
        panel2.add(C);
        panel2.add(D);
        panel2.setBackground(Color.PINK);
        panel2.setPreferredSize(new Dimension(200, 40));
        
        
        frame1.add(panel2);
        
        quiz = new Quiz(){};
        
        this.populateQuiz(quiz);
        totalCorrect = 0;
        thismf = this;
        
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }//End mainFrame
    
    public void populateQuiz(Quiz qz){
    
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

            Question question = new Question("What is " + x + " + " + y + "?", answerArray);
            question.addAnswer("A. " + (intList.get(0)));
            question.addAnswer("B. " + (intList.get(1)));
            question.addAnswer("C. " + (intList.get(2)));
            question.addAnswer("D. " + (intList.get(3)));
            qz.addQuestion(question);
        }//End for loop 
    }//End populateQuiz
    
    private static int getRandomNumber() 
    {
        Random rand = new Random();
        return rand.nextInt(10) + 1;
    }//End getRandomNumber()  
    
    public class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {           
            if(e.getSource() == A)
            {
                if(answers[0] == true)
                {
                    System.out.println("That's a correct answer!");
                    totalCorrect += 1;
                }//End if case A
                else
                {
                    System.out.println("Too bad, that's a wrong answer!");
                }//End else case A
                answered = true; 
            }//End if
            else if (e.getSource() == B)
            {
                if(answers[1] == true)
                {
                    System.out.println("That's a correct answer!");
                    totalCorrect += 1;
                }//End if case B
                else
                {
                    System.out.println("Too bad, that's a wrong answer!");
                }//End else case B
                answered = true;
            }//End else if
            else if (e.getSource() == C)
            {
                if(answers[2] == true)
                {
                    System.out.println("That's a correct answer!");
                    totalCorrect += 1;
                }//End if case C
                else
                {
                    System.out.println("Too bad, that's a wrong answer!");
                }//End else case C
                answered = true;
            }//End else if
            else if (e.getSource() == D)
            {
                if(answers[3] == true)
                {
                    System.out.println("That's a correct answer!");
                    totalCorrect += 1;
                }//End if case D
                else
                {
                    System.out.println("Too bad, that's a wrong answer!");
                }//End else case D
                answered = true;
            }//End else if
            totalLabel.setText("Total Correct:" + totalCorrect);     
        }//End actionPerformed
    }//End ButtonListener
    
    // Implement the Runnable interface
    public class MyRunnable implements Runnable 
    {
        @Override
        public void run() 
        {
            // Method to run in another thread
               quiz.giveQuiz(choiceLabel1, choiceLabel2, choiceLabel3, choiceLabel4, questionLabel, thismf);
        }//End run
    }//End MyRunnable  
}//End mainFrame

