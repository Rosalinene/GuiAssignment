
package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class mainFrame extends JPanel
{
    private JFrame frame1;
    private JPanel panel2;
    
    public mainFrame()
    {
        frame1 = new JFrame();
        frame1.setTitle("Assignment 1 Quiz");
        frame1.setSize(400,400);
        frame1.setResizable(false);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        panel2 = new JPanel();
        panel2.setLayout(null);
        
        
    }//End mainFrame
    
}//End mainFrame
