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
class MyFrame1
        extends JFrame
        implements ActionListener {

    // Components of the Form
    private Container c;
    private JLabel title1;
    private JLabel from_loc;
    private JLabel to_loc;
    private JLabel dor;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JComboBox froml;
    private JComboBox tol;
    private String text = "Read Terms and Conditions";
    private JLabel hyperlink = new JLabel(text);

    private JLabel cartype;
    private JRadioButton lux;
    private JRadioButton micro;
    private JRadioButton mini;
    private JRadioButton prime;
    private ButtonGroup typegp;

    JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JTextArea tout1;
    private JLabel res;
    private JLabel res1;
    // private JTextArea resadd;
    private String from[] = { "Gandhipuram", "town hall", "RS puram", "CIT", "Neelambur" };
    private String to[] = { "Gandhipuram", "town hall", "RS puram", "CIT", "Neelambur" };
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
    private String years[] = { "2022", "2023" };
    private Component btnNewButton;
    examp EX = new examp();
    // constructor, to initialize the components
    // with default values.
    public MyFrame1() {
        setTitle("cab Booking Form");
        setBounds(20, 20, 1200, 700);
        // setBounds(300, 90, 900, 600);
        getContentPane().setBackground(Color.gray);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title1 = new JLabel("BOOK YOUR CAB");
        title1.setFont(new Font("Serif", Font.BOLD, 25));
        title1.setSize(300, 30);
        title1.setLocation(300, 30);
        c.add(title1);

        from_loc = new JLabel("From Location: ");
        from_loc.setFont(new Font("Arial", Font.PLAIN, 20));
        from_loc.setSize(160, 20);
        from_loc.setLocation(100, 150);
        c.add(from_loc);

        froml = new JComboBox(from);
        froml.setFont(new Font("Arial", Font.PLAIN, 15));
        froml.setSize(150, 20);
        froml.setLocation(250, 150);

        c.add(froml);

        /*
         * tfrom_loc = new JTextField();
         * tfrom_loc.setFont(new Font("Tahoma", Font.PLAIN, 15));
         * tfrom_loc.setSize(150, 20);
         * tfrom_loc.setLocation(250, 100);
         * c.add(tfrom_loc);
         */

        to_loc = new JLabel("To Location: ");
        to_loc.setFont(new Font("Arial", Font.PLAIN, 20));
        to_loc.setSize(300, 20);
        to_loc.setLocation(100, 200);

        c.add(to_loc);

        tol = new JComboBox(to);
        tol.setFont(new Font("Arial", Font.PLAIN, 15));
        tol.setSize(150, 20);
        tol.setLocation(240, 200);
        c.add(tol);

        dor = new JLabel("Date of ride: ");
        dor.setFont(new Font("Arial", Font.PLAIN, 20));
        dor.setSize(200, 20);
        dor.setLocation(100, 250);
        c.add(dor);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(70, 20);
        date.setLocation(230, 250);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(100, 20);
        month.setLocation(290, 250);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(100, 20);
        year.setLocation(380, 250);
        c.add(year);

        cartype = new JLabel("Car Type: ");
        cartype.setFont(new Font("Arial", Font.PLAIN, 20));
        cartype.setSize(100, 22);
        cartype.setLocation(100, 300);
        c.add(cartype);

        lux = new JRadioButton("LUXURY(7)");
        lux.setFont(new Font("Arial", Font.PLAIN, 15));
        lux.setSelected(true);
        lux.setSize(100, 20);
        lux.setLocation(250, 300);
        c.add(lux);

        prime = new JRadioButton("Prime(5)");
        prime.setFont(new Font("Arial", Font.PLAIN, 15));
        prime.setSelected(false);
        prime.setSize(100, 20);
        prime.setLocation(400, 301);
        c.add(prime);

        mini = new JRadioButton("Mini(4)");
        mini.setFont(new Font("Arial", Font.PLAIN, 15));
        mini.setSelected(false);
        mini.setSize(100, 20);
        mini.setLocation(550, 302);
        c.add(mini);

        micro = new JRadioButton("Micro(4)");
        micro.setFont(new Font("Arial", Font.PLAIN, 15));
        micro.setSelected(false);
        micro.setSize(100, 20);
        micro.setLocation(700, 303);
        c.add(micro);

        typegp = new ButtonGroup();
        typegp.add(lux);
        typegp.add(prime);
        typegp.add(micro);
        typegp.add(mini);

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 400);
        c.add(term);

        hyperlink.setFont(new Font("Arial", Font.PLAIN, 15));
        hyperlink.setSize(250, 20);
        hyperlink.setLocation(169, 430);
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

        // setLayout(new FlowLayout());
        getContentPane().add(hyperlink);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 500);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 500);
        reset.addActionListener(this);
        c.add(reset);

        tout1 = new JTextArea();
        tout1.setFont(new Font("Arial", Font.PLAIN, 15));
        tout1.setSize(300, 400);
        tout1.setLocation(800, 100);
        tout1.setLineWrap(true);
        tout1.setEditable(false);
        c.add(tout1);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 450);
        c.add(res);

        
        if(EX.UN==null){
            nuser N= new nuser();
            EX.UN=N.newu;
        }
        res1 = new JLabel("Hello "+EX.UN);
        res1.setFont(new Font("Arial", Font.PLAIN, 20));
        res1.setSize(150, 20);
        res1.setLocation(100, 100);
        c.add(res1);


        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public int invaliddate(String d,String m,String y){
        int result=0;
        if(m=="feb")
        {
            
            if(d=="29"||d=="30"||d=="31")
            
            result=1;
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
    @Override
    public void actionPerformed(ActionEvent e1) {

        if (e1.getSource() == sub) {

            if (term.isSelected()) {
                String dt3, data3;
                // example e = new example();
                // e.username = tuname.getText();
                //JOptionPane.showMessageDialog(btnNewButton, e.username);
                Connection conn = null;
                Statement stmt = null;
                //examp name = new examp();
                    
                        String day = (String) date.getSelectedItem();
                        String mon = (String) month.getSelectedItem();
                        String yr = (String) year.getSelectedItem();
                        String data = "From Location : " + (String) froml.getSelectedItem() + "\n" + "To Location : "
                                + (String) tol.getSelectedItem() + "\n";
                        String data2 = "Date of Ride : " + (String) date.getSelectedItem() + "/"
                                + (String) month.getSelectedItem()
                                + "/" + (String) year.getSelectedItem() + "\n";

                        if (lux.isSelected()) {
                            dt3 = "Luxury";
                            data3 = "Car Type : Luxury (7)" + "\n";
                        } else if (prime.isSelected()) {
                            dt3 = "Prime";
                            data3 = "Car Type : Prime (5)" + "\n";
                        } else if (mini.isSelected()) {
                            dt3 = "Mini";
                            data3 = "Car Type : Mini (4)" + "\n";
                        } else {
                            dt3 = "Micro";
                            data3 = "Car Type : Micro (4)" + "\n";
                        }
                        if ((String) froml.getSelectedItem() == (String) tol.getSelectedItem()) {
                            JOptionPane.showMessageDialog(this, "From and to location cannot be same");
                        } else {
                            if(invaliddate(day,mon,yr)==1){
                                JOptionPane.showMessageDialog(btnNewButton, "Enter Valid date");
                            }
                            else{
                                tout1.setText(data + data2 + data3);
                            tout1.setEditable(false);
                            try {
                                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab", "root",
                                        "24gerarasw");
                                //JOptionPane.showMessageDialog(btnNewButton, EX.UN);
                                String query = "INSERT INTO bookdetails(uname,from_loc,to_loc,days,mon,yr,car_ty) values('"
                                        + EX.UN + "','" + (String) froml.getSelectedItem() + "','"
                                        + (String) tol.getSelectedItem() + "','" +
                                        day + "','" + mon + "','" + yr + "','" + dt3 + "')";
                                // JOptionPane.showMessageDialog(btnNewButton, "connection success");
                                stmt = conn.createStatement();
                                stmt.executeUpdate(query);
                            } catch (Exception exception) {
                                exception.printStackTrace();
                            }
                            // res.setText("Registered Successfully..");
                            JOptionPane.showMessageDialog(this, "Booked Successfully");
                            JButton b = new JButton("Ok");
                            b.addActionListener(this);
                            new MyFrame2();
                            // new MyFrame2(tfrom_loc).setVisble(true);
                            this.dispose();
                            }
                            
                        }
                        

            } else {
                tout1.setText("");
                // resadd.setText("");
                res.setText("Please accept the"
                        + " terms & conditions..");
            }
        }

        else if (e1.getSource() == reset) {
            String def = "";
            res.setText(def);
            tout1.setText(def);
            term.setSelected(false);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
            // resadd.setText(def);
        }
    }
}
// Driver Code
class booking {

    public static void main(String[] args) throws Exception {
        MyFrame1 f = new MyFrame1();
        // MyFrame2 f1=new MyFrame2();
    }
}
