
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
class MyFrame5
        extends JFrame
        implements ActionListener {
    
    private Container c;
    private JLabel title;
    private JLabel confirm;
    private JLabel safe;
    private JButton okbutton;
    
    public MyFrame5() {
        setTitle("End box");
        setBounds(20, 20, 1200, 700);
        getContentPane().setBackground(Color.gray);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("THANK YOU!..");
        title.setFont(new Font("Serif", Font.BOLD, 25));
        title.setSize(300, 30);
        title.setLocation(480, 30);
        c.add(title);

        confirm = new JLabel("Booking Confirmed");
        confirm.setFont(new Font("Arial", Font.PLAIN, 20));
        confirm.setSize(180, 30);
        confirm.setLocation(450, 200);
        c.add(confirm);

        safe = new JLabel("Have A Safe Ride");
        safe.setFont(new Font("Arial", Font.PLAIN, 20));
        safe.setSize(160, 20);
        safe.setLocation(450, 250);
        c.add(safe);

       

        okbutton = new JButton("OK");
        okbutton.setFont(new Font("Arial", Font.PLAIN, 15));
        okbutton.setSize(100, 20);
        okbutton.setLocation(500, 300);
        okbutton.addActionListener(this);
        c.add(okbutton);

      
        setVisible(true);
    }

// method actionPerformed()
// to get the action performed
// by the user and act accordingly
    @Override
    public void actionPerformed(ActionEvent e1) 
    {
       if (e1.getSource() == okbutton) 
        {                   
                okbutton.addActionListener(this);
                this.dispose();    
        }
 
    }  
        
    
}



public class endbox {
     public static void main(String[] args) throws Exception {
        MyFrame5 f = new MyFrame5();
}
}