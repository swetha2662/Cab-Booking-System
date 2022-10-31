import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class MyFrame3
        extends JFrame
        implements ActionListener {

// Components of the Form
    private Container c;
    private JLabel title;
    private JLabel myothers;
   private JRadioButton myself;
    private JRadioButton others;
    private ButtonGroup myothersgp;
    private JButton okbutton;
   

// constructor, to initialize the components
// with default values.
    public MyFrame3() {
        setTitle("BOOKING CHECK");
        setBounds(20, 20, 1200, 700);
//setBounds(300, 90, 900, 600);
        getContentPane().setBackground(Color.gray);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("CONFIRMATION");
        title.setFont(new Font("Serif", Font.BOLD, 25));
        title.setSize(300, 30);
        title.setLocation(450, 30);
        c.add(title);
        
     

        myothers = new JLabel("Booking For");
        myothers.setFont(new Font("Arial", Font.PLAIN, 20));
        myothers.setSize(200, 20);
        myothers.setLocation(380, 200);
        c.add(myothers);

        myself = new JRadioButton("Myself");
        myself.setFont(new Font("Arial", Font.PLAIN, 15));
        myself.setSelected(true);
        myself.setSize(75, 20);
        myself.setLocation(500, 200);
        c.add(myself);

        others = new JRadioButton("Others");
        others.setFont(new Font("Arial", Font.PLAIN, 15));
        others.setSelected(false);
        others.setSize(80, 20);
        others.setLocation(600, 200);
        c.add(others);

        myothersgp = new ButtonGroup();
        myothersgp.add(myself);
        myothersgp.add(others);

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
    public void actionPerformed(ActionEvent e) {
        if (myself.isSelected()&&e.getSource() == okbutton) {
           
                myself.addActionListener(this);
                new MyFrame5();
                this.dispose();
            }
        else if (others.isSelected()&&e.getSource() == okbutton) {
           others.addActionListener(this);
                new MyFrame4();
                this.dispose();
        }
    }
}

// Driver Code
class myselfandothers {

    public static void main(String[] args) throws Exception {
        MyFrame3 f = new MyFrame3();
        
    }
}