import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
class ex{
    public static String UName;
}
class LoginFrame extends JFrame implements ActionListener {

    private JLabel titlename;
    
    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JButton newuserbutton = new JButton("NEW USER? REGISTER");
    JCheckBox showPassword = new JCheckBox("Show Password");

    private Component btnNewButton;

    LoginFrame() {
        getContentPane().setBackground(Color.GRAY);
        titlename = new JLabel("BOOK YOUR CAB");
        titlename.setFont(new Font("Times", Font.BOLD, 25));

        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        titlename.setBounds(530, 100, 300, 30);
        userLabel.setBounds(500, 180, 100, 30);
        passwordLabel.setBounds(500, 250, 100, 30);
        userTextField.setBounds(600, 180, 150, 30);
        passwordField.setBounds(600, 250, 150, 30);
        showPassword.setBounds(550, 310, 150, 30);
        loginButton.setBounds(500, 390, 100, 30);
        resetButton.setBounds(650, 390, 100, 30);
        newuserbutton.setBounds(530, 480, 200, 30);
    }

    public void addComponentsToContainer() {
        container.add(titlename);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(newuserbutton);

    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        newuserbutton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            ex E1=new ex();
            E1.UName=userTextField.getText();
            //JOptionPane.showMessageDialog(btnNewButton, E1.UName);
            pwdText = passwordField.getText();
            if(userText.equals("")){
                JOptionPane.showMessageDialog(btnNewButton, "Enter the user name ");
            }
            if(pwdText.equals("")){
                JOptionPane.showMessageDialog(btnNewButton, "Enter the password ");
            }
            else{
            Connection conn = null;
            Statement stmt = null;
            try{
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cab", "root",
                                        "root123");
                                // JOptionPane.showMessageDialog(btnNewButton, "connection success");
                                stmt = conn.createStatement();
            String sql = "Select * from users1 Where uname='" + userText + "' and pwd='" + pwdText + "'";
            ResultSet rs = stmt.executeQuery(sql);   
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                JButton b = new JButton("Ok");
                b.addActionListener(this);
                new MyFrame1();
                this.dispose();
            } else {
                E1.UName=null;
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        }
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }

        }
        
        if (e.getSource() == newuserbutton)
        {
            newuserbutton.addActionListener(this);
                new MyFrame();
                this.dispose();
        }
    }

}
class examp{
ex E=new ex();
String UN=E.UName;
}
public class login {

    public static void main(String[] a) {
        LoginFrame frame = new LoginFrame();

        frame.getContentPane().setBackground(Color.GRAY);
        frame.setTitle("BOOK YOUR CAB");
        frame.setVisible(true);
        frame.setBounds(20, 20, 1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }

}