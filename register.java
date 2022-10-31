import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
class username{
    public static String newuser;
}

class MyFrame extends JFrame implements ActionListener {

    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel uname;
    private JTextField tuname;
    private JLabel pname;
    private JTextField tpname;
    private JLabel mno;
    private JTextField tmno;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JLabel dob;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JLabel add;
    private JTextArea tadd;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JLabel cpname;
    private JTextField ctpname;
    private String text = "Read Terms and Conditions";
    private JLabel hyperlink = new JLabel(text);


    private String dates[] = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[] = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    private String years[] = { "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019" };
    private Component btnNewButton;

    // constructor, to initialize the components
    // with default values.
    public MyFrame() {
        setTitle("Registration Form");
        setBounds(20, 20, 1200, 700);
        // setBounds(300, 90, 900, 600);
        getContentPane().setBackground(Color.GRAY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("REGISTER");
        title.setFont(new Font("Serif", Font.BOLD, 25));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        uname = new JLabel("New UserName");
        uname.setFont(new Font("Arial", Font.PLAIN, 20));
        uname.setSize(150, 20);
        uname.setLocation(100, 100);
        c.add(uname);

        tuname = new JTextField();
        tuname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tuname.setSize(180, 20);
        tuname.setLocation(290, 100);
        c.add(tuname);

        pname = new JLabel("New Password");
        pname.setFont(new Font("Arial", Font.PLAIN, 20));
        pname.setSize(180, 20);
        pname.setLocation(100, 150);
        c.add(pname);

        tpname = new JPasswordField();
        tpname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tpname.setSize(120, 20);
        tpname.setLocation(290, 150);
        c.add(tpname);

        cpname = new JLabel("Confirm New Password");
        cpname.setFont(new Font("Arial", Font.PLAIN, 20));
        cpname.setSize(250, 20);
        cpname.setLocation(430, 150);
        c.add(cpname);

        ctpname = new JPasswordField();
        ctpname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        ctpname.setSize(120, 20);
        ctpname.setLocation(650, 150);
        c.add(ctpname);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 200);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(290, 200);
        c.add(tname);

        mno = new JLabel("Mobile");
        mno.setFont(new Font("Arial", Font.PLAIN, 20));
        mno.setSize(100, 20);
        mno.setLocation(100, 250);
        c.add(mno);

        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(190, 20);
        tmno.setLocation(290, 250);
        c.add(tmno);

        tmno.addKeyListener(new KeyAdapter() {
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
      
        gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(100, 290);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(290, 290);
        c.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(390, 290);
        c.add(female);

        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);

        dob = new JLabel("DOB");
        dob.setFont(new Font("Arial", Font.PLAIN, 20));
        dob.setSize(100, 20);
        dob.setLocation(100, 320);
        c.add(dob);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(70, 20);
        date.setLocation(290, 320);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(80, 20);
        month.setLocation(350, 320);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(85, 20);
        year.setLocation(420, 320);
        c.add(year);

        add = new JLabel("Address");
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        add.setSize(100, 20);
        add.setLocation(100, 360);
        c.add(add);

        tadd = new JTextArea();
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        tadd.setSize(200, 75);
        tadd.setLocation(290, 360);
        tadd.setLineWrap(true);
        c.add(tadd);



        term = new JCheckBox("Accept terms and conditions");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 480);
        c.add(term);
        
        hyperlink.setFont(new Font("Arial", Font.PLAIN, 15));
        hyperlink.setSize(250, 20);
        hyperlink.setLocation(170, 500);
        c.add(hyperlink);

        hyperlink.setForeground(Color.BLUE.darker());
        hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));

        hyperlink.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://oneway.cab/Terms-And-Conditions.html"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hyperlink.setText(text);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hyperlink.setText("<html><a href=''>" + text + "</a></html>");
            }

        });

        //setLayout(new FlowLayout());
        getContentPane().add(hyperlink);
        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 600);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 600);
        reset.addActionListener(this);
        c.add(reset);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(800, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 550);
        c.add(res);

        // resadd = new JTextArea();
        // resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        // resadd.setSize(200, 75);
        // resadd.setLocation(580, 175);
        // resadd.setLineWrap(true);
        // c.add(resadd);

        setVisible(true);
    }
    public int invaliddate(String d,String m,String y){
        int result=0;
        if(m=="feb")
        {
             if(y=="1996" || y=="2000" || y=="2004" || y=="2008" || y=="2012" ||y=="2016")
            {
            if(d=="30"||d=="31")
                result=1;
                //JOptionPane.showMessageDialog(btnNewButton, "Enter Valid date");
            }
            else if(d=="29"||d=="30"||d=="31")
            result=1;
            //}
        }

        if(m=="Apr" || m=="Jun" || m=="Sup" || m=="Nov")
        {
            if(d=="31")
            {
            result=1;
            }
        }
        return result;
    }
    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    @Override
    public void actionPerformed(ActionEvent e) {
        username n1=new username();
        n1.newuser = tuname.getText();
        String passwd = tpname.getText();
        String cpasswd = ctpname.getText();
        String Name = tname.getText();
        String mobileNumber = tmno.getText();
        int len = mobileNumber.length();
        String address = tadd.getText();
        String day = (String) date.getSelectedItem();
        String month1 = (String) month.getSelectedItem();
        String yr = (String) year.getSelectedItem();
        if (Name.equals("") || n1.newuser.equals("")) {
            JOptionPane.showMessageDialog(btnNewButton, "Enter Name");
        }
        else{
            if (address.equals("")) {
                JOptionPane.showMessageDialog(btnNewButton, "Enter address");
            } 
            else{
                if(cpasswd.equals(passwd)){
                    if (passwd.equals("")) {
                        JOptionPane.showMessageDialog(btnNewButton, "Enter password");
                    }
                    else{
                        if(len!=10){
                            JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                        }
                        else{
                            if(invaliddate(day,month1,yr)==1){
                                JOptionPane.showMessageDialog(btnNewButton, "Enter Valid date");
                            }
                            else{
                                if (e.getSource() == sub) {
                                    if (term.isSelected()) {
                                        String data1;
                                        String data = "Name : "
                                                + tname.getText() + "\n"
                                                + "Mobile : "
                                                + tmno.getText() + "\n";
                                        if (male.isSelected()) {
                                            data1 = "Gender : Male"
                                                    + "\n";
                                        } else {
                                            data1 = "Gender : Female"
                                                    + "\n";
                                        }
                                        String data2 = "DOB : "
                                                + (String) date.getSelectedItem()
                                                + "/" + (String) month.getSelectedItem()
                                                + "/" + (String) year.getSelectedItem()
                                                + "\n";
            
                                        String data3 = "Address : " + tadd.getText();
                                        tout.setText(data + data1 + data2 + data3);
                                        tout.setEditable(false);
                                        Connection conn = null;
                                        Statement stmt = null;
                                        String m = "Male";
                                        String f = "Female";
                                        try {
                                            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab", "root",
                                                    "root123");
                                            // JOptionPane.showMessageDialog(btnNewButton, "connection success");
                                            stmt = conn.createStatement();
                                            String q1 = "INSERT INTO users1(uname,pwd) values('" + n1.newuser + "','" + passwd + "')";
                                            stmt.executeUpdate(q1);
                                            if (male.isSelected()) {
                                                //JOptionPane.showMessageDialog(btnNewButton,"Welcome, Your account issucessfully created");
                                                String query1 = "INSERT INTO pdetails(uname,pwd,name,mob,address,day,month,yr,gender) values('"
                                                        + n1.newuser + "','" + passwd + "','" + Name + "','" + mobileNumber + "','"
                                                        + address + "','" +
                                                        day + "','" + month1 + "','" + yr + "','" + m + "')";
                                                int x = stmt.executeUpdate(query1);
                                                if (x == 0)
                                                    JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                                                 //JOptionPane.showMessageDialog(btnNewButton,"Welcome, Your account is sucessfully created");
                                                conn.close();
                                            } else {
                                                //JOptionPane.showMessageDialog(btnNewButton,"Welcome female, Your account is sucessfully created");
                                                String query2 = "INSERT INTO pdetails(uname,pwd,name,mob,address,day,month,yr,gender) values('"
                                                + n1.newuser + "','" + passwd + "','" + Name + "','" + mobileNumber + "','"
                                                + address + "','" +
                                                day + "','" + month1 + "','" + yr + "','" + f + "')";
                                                int x = stmt.executeUpdate(query2);
                                                if (x == 0)
                                                    JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                                                conn.close();
                                            }
                                        } catch (Exception exception) {
                                            exception.printStackTrace();
                                        }
                                        JOptionPane.showMessageDialog(this, "Regitration Successful");
                                        JButton b = new JButton("Ok");
                                        b.addActionListener(this);
                                        new MyFrame1();
                                        this.dispose();
                                    }
                                    else {
                                        tout.setText("");
                                        //resadd.setText("");
                                        res.setText("Please accept the"
                                                + " terms & conditions..");
                                    }
                                }
                                else if (e.getSource() == reset) {
                                    String def = "";
                                    tuname.setText(def);
                                    tpname.setText(def);
                                    tname.setText(def);
                                    tadd.setText(def);
                                    tmno.setText(def);
                                    res.setText(def);
                                    tout.setText(def);
                                    term.setSelected(false);
                                    date.setSelectedIndex(0);
                                    month.setSelectedIndex(0);
                                    year.setSelectedIndex(0);
                                    //resadd.setText(def);
            
                                }
        
                            }

                        }  
                      
                    }    
                }
                else{
                    JOptionPane.showMessageDialog(btnNewButton, "check password");
                }
               
                
            }
        }  
}      
}  
class nuser{
    username n=new username();
    String newu=n.newuser;
}
// Driver Code
public class register {

    public static void main(String[] args) throws Exception {
        MyFrame f = new MyFrame();

    }
}
