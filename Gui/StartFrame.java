
package Gui;

//Imports declare
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class StartFrame extends JPanel
{
    private JButton startButton, exitButton;
    private JLabel label1;
    private JPanel panel1;
    private JFrame jframe1;
    public mainFrame mFrame1;
    
    public StartFrame()
    {
        startButton = new JButton("Start");
        exitButton = new JButton("Exit");
        
        ButtonListener listener = new ButtonListener();
        startButton.addActionListener(listener);
        exitButton.addActionListener(listener);
         jframe1 = new JFrame("panel");
        
        panel1 = new JPanel();
        panel1.add(startButton);
        panel1.add(exitButton);
        panel1.setBackground(Color.PINK);
        panel1.setPreferredSize(new Dimension(200, 40));
        
        jframe1.setTitle("Starting Frame");
        jframe1.setSize(400,400);
        jframe1.setResizable(false);
        jframe1.setLocationRelativeTo(null);
        jframe1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jframe1.setVisible(true);
        
        jframe1.add(panel1);
    }//End StartFrame()
    
    private class ButtonListener implements 
                                        ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {           
            if(e.getSource() == startButton)
            {
                mFrame1 = new mainFrame();
            }//End if
            else if(e.getSource() == exitButton)
            {
                exitFrame eframe = new exitFrame();
            }//End else if  
        }//End actionPerformed
    }//End ButtonListener
}//End StartFrame
