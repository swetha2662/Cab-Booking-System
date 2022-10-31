import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class MyFrame2
        extends JFrame
        implements ActionListener {

// Components of the Form
    private Container c;
    private JLabel title;
    private JButton show;
    private JButton okbutton;
    private JButton backbutton;
    private JTextArea tout2;
    private JTextArea tout3;
    //private Component btnNewButton;
    private Component btnNewButton;
  
    public MyFrame2() {
        // JFrame jframe = new JFrame("JFrame Background Color");
        // jframe.setBackground(Color.gray);
        
        setTitle("Confiramtion Form");
        setBounds(20, 20, 1200, 700);
        getContentPane().setBackground(Color.gray);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("CONFIRMATION");
        title.setFont(new Font("Serif", Font.BOLD, 25));
        title.setSize(300, 30);
        title.setLocation(550, 30);
        c.add(title);

        show = new JButton("SHOW");
        show.setFont(new Font("Arial", Font.PLAIN, 15));
        show.setSize(100, 20);
        show.setLocation(600, 66);
        show.addActionListener(this);
        c.add(show);

        okbutton = new JButton("CONFIRM");
        okbutton.setFont(new Font("Arial", Font.PLAIN, 15));
        okbutton.setSize(110, 20);
        okbutton.setLocation(500, 550);
        okbutton.addActionListener(this);
        c.add(okbutton);

        backbutton = new JButton("BACK");
        backbutton.setFont(new Font("Arial", Font.PLAIN, 15));
        backbutton.setSize(100, 20);
        backbutton.setLocation(700, 550);
        backbutton.addActionListener(this);
        c.add(backbutton);

        tout2 = new JTextArea();
        tout2.setFont(new Font("Arial", Font.PLAIN, 15));
        tout2.setSize(300, 106);
        tout2.setLocation(500, 100);
        tout2.setLineWrap(true);
        tout2.setEditable(false);
        c.add(tout2);
        
        tout3 = new JTextArea();
        tout3.setFont(new Font("Arial", Font.PLAIN, 15));
        tout3.setSize(300, 300);
        tout3.setLocation(500, 206);
        tout3.setLineWrap(true);
        tout3.setEditable(false);
        c.add(tout3);

        setVisible(true);
    }

// method actionPerformed()
// to get the action performed
// by the user and act accordingly

    @Override
    public void actionPerformed(ActionEvent e) {
        examp nam = new examp();
            if(nam.UN==null){
                nuser N= new nuser();
                nam.UN=N.newu;
            }
        if(e.getSource() == show){
            Connection conn = null;
            Statement stmt = null;
            
            
            //JOptionPane.showMessageDialog(btnNewButton, nam.UN); 
        //String uname="dharun";
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab", "root",
                    "root123");
                   
            String qu="Select pdetails.name,pdetails.mob,bookdetails.from_loc,bookdetails.to_loc,bookdetails.days,bookdetails.mon,bookdetails.yr,bookdetails.car_ty from pdetails join bookdetails on pdetails.uname=bookdetails.uname where bookdetails.uname='" + nam.UN+ "'";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(qu);
            while (rs.next()) {
                
                tout2.setText("Name: "+rs.getString("name")+"\n"+"Mobile number: "+rs.getString("mob")+"\n"+"From location: "+rs.getString("from_loc")+"\nTo Location: "+rs.getString("to_loc")+"\n Ride date: "+rs.getString("days")+"/"+rs.getString("mon")+"/"+rs.getString("yr")+"\nCar type: "+rs.getString("car_ty"));
                
            }
            // String name="Select bookdetails.uname from bookdetails  join pdetails   on pdetails.uname=bookdetails.uname";
            // stmt = conn.createStatement();
            // stmt.executeQuery(name);
            String loc="Select kilometer.km,kilometer.fare from kilometer join bookdetails on bookdetails.from_loc =kilometer.froml where bookdetails.to_loc =kilometer.tol and bookdetails.uname ='"+ nam.UN+ "'";
            stmt = conn.createStatement();
            ResultSet rs1 = stmt.executeQuery(loc);
            while (rs1.next()) {
                tout3.setText("Kilometer : "+rs1.getString("km")+"\n"+"Fare : "+rs1.getString("fare"));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        
        }
        if(e.getSource()==okbutton){
                
            okbutton.addActionListener(this);
            new MyFrame3();
            // new MyFrame2(tfrom_loc).setVisble(true);
            this.dispose();
        }
        if(e.getSource()==backbutton){
                
            okbutton.addActionListener(this);
            new MyFrame1();
            try {
                Connection conn = null;
                Statement stmt = null;
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab", "root",
                        "root123");
                String q="delete from bookdetails Where uname='" + nam.UN + "'";
                stmt = conn.createStatement();
                stmt.executeUpdate(q); 
                
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            this.dispose();
        }
        
}
}

// Driver Code
class confiramtion {

    public static void main(String[] args) throws Exception {
        MyFrame2 f = new MyFrame2();
        //MyFrame1 m = new MyFrame1();
        
        
    }
}
