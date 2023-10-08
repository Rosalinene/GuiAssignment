
package Gui;

//Imports declare
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartFrame extends JPanel
{
    private JButton startButton, exitButton;
    private JLabel label1;
    private JPanel panel1;
    
    public StartFrame()
    {
        startButton = new JButton("Start");
        exitButton = new JButton("Exit");
        
        ButtonListener listener = new ButtonListener();
        startButton.addActionListener(listener);
        exitButton.addActionListener(listener);
        
        label1 = new JLabel("ASSIGNMENT 1 QUIZ");
        
        panel1 = new JPanel();
        panel1.add(startButton);
        panel1.add(exitButton);
        panel1.setBackground(Color.PINK);
        panel1.setPreferredSize(new Dimension(200, 40));
        
        this.add(label1);
        this.add(panel1);
        
        this.setBackground(Color.CYAN);
        this.setPreferredSize(new Dimension(200, 80));
    }
    
    private class ButtonListener implements 
                                        ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {           
            if(e.getSource() == startButton)
            {
                label1.setText("Start");
                mainFrame();
            }//End if
            else
            {
                label1.setText("Exit");
                
            }//End else
                
        }//End actionPerformed
    }//End ButtonListener
}//End StartFrame
