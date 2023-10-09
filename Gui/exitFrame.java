
package Gui;

//Imports declare
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class exitFrame 
{
    private final JLabel label1;
    private final JPanel panel1;
    private final JFrame jframe1;
    
    public exitFrame()
    {
        panel1 = new JPanel();
        panel1.setBackground(Color.PINK);
        panel1.setPreferredSize(new Dimension(200, 40));
        
        jframe1 = new JFrame();
        jframe1.setTitle("Ending Frame");
        jframe1.setSize(400,400);
        jframe1.setResizable(false);
        jframe1.setLocationRelativeTo(null);
        jframe1.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jframe1.setVisible(true);
        
        label1 = new JLabel("Thank you for taking the quiz!");
        panel1.add(label1);
        jframe1.add(panel1);
    }//End exitFrame()
}//End class exitFrame
