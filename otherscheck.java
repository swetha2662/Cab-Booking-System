/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class MyFrame4
        extends JFrame
        implements ActionListener {
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel mno;
    private JTextField tmno;
    private JButton okbutton;
    private Component btnNewButton;
        public MyFrame4() {
        setTitle("Others box");
        setBounds(20, 20, 1200, 700);
        getContentPane().setBackground(Color.gray);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("DETAILS OF THE TRAVELLER");
        title.setFont(new Font("Serif", Font.BOLD, 25));
        title.setSize(400, 30);
        title.setLocation(450, 30);
        c.add(title);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(450, 200);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(550, 200);
        c.add(tname);

        mno = new JLabel("Mobile");
        mno.setFont(new Font("Arial", Font.PLAIN, 20));
        mno.setSize(100, 20);
        mno.setLocation(450, 250);
        c.add(mno);

        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(190, 20);
        tmno.setLocation(550, 250);
        c.add(tmno);

        tmno.addKeyListener(new KeyAdapter() {
            private Component btnNewButton;

            public void keyPressed(KeyEvent ke) {
               String value = tmno.getText();
               int l = value.length();
               if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                  tmno.setEditable(true);
                   
               }
                else {
                  tmno.setText("");  
                  tmno.setEditable(true);
                  JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
               }
            }
         });

        okbutton = new JButton("OK");
        okbutton.setFont(new Font("Arial", Font.PLAIN, 15));
        okbutton.setSize(100, 20);
        okbutton.setLocation(500, 300);
        okbutton.addActionListener(this);
        c.add(okbutton);

      
        setVisible(true);
        
        
    }
          public void actionPerformed(ActionEvent e1) 
    {
       if (e1.getSource() == okbutton) 
        {   
            String Name=tname.getText();
            String mobno=tmno.getText();
            int len =mobno.length();
            if(len!=10){
                JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
            }  
            else{

                Connection conn = null;
                Statement stmt = null;
                try{     
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab", "root","root123");
                stmt = conn.createStatement();
                String ql =  "INSERT INTO others(oname,mno) values('" + Name +  "','" + mobno + "')";
                stmt.executeUpdate(ql);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }             
                    okbutton.addActionListener(this);
                    new MyFrame5();
                    this.dispose();      
            }
            
        }
 
    }  
}



public class otherscheck {
     public static void main(String[] args) throws Exception {
        MyFrame4 f = new MyFrame4();
}
}