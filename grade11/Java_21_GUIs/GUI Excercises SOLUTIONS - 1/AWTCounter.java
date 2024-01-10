import java.awt.*;         // Using AWT containers and components
import java.awt.event.*;   // Using AWT events and listener interfaces
import javax.swing.*;

// An AWT GUI program inherits the top-level container Frame
public class AWTCounter extends JFrame implements ActionListener {
    private Label lblCount;     // declare component Label
    private JTextField tfCount;  // declare component TextField
    private JButton btnCount;    // declare component Button
    private int count = 0;      // counter's value
    
    // Constructor to setup UI components
    public AWTCounter () {
      
        Container content = getContentPane();
        // Frame sets layout to FlowLayout, which arranges
        //  Components from left-to-right, then top-to-bottom.
        content.setLayout(new FlowLayout());
        
        
        lblCount = new Label("Counter"); // allocate Label instance
        add(lblCount);                   // "this" Frame adds Label
        
        tfCount = new JTextField(count + "", 10); // allocate
        tfCount.setEditable(false);       // read-only
        add(tfCount);                     
        
        btnCount = new JButton("Count");   // allocate Button instance
        add(btnCount);                    // "this" Frame adds btnCount
        btnCount.addActionListener(this);
        // btnCount is a source that fires ActionEvent when clicked.
        // The source add "this" object as a listener, which provides
        //  the ActionEvent handler called actionPerformed().
        // Clicking btnCount invokes actionPerformed().
        
        pack();       
        setVisible(true);     
    }
    
    // ActionEvent handler - Called back when the button has been clicked.
 
    public void actionPerformed(ActionEvent evt) {
        ++count;                     // incrase the counter value
        tfCount.setText(count + ""); // display on the TextField
        // setText() takes a String
    }
    
    // The entry main() method
    public static void main(String[] args) {
        // Invoke the constructor by allocating an anonymous instance
        AWTCounter counter = new AWTCounter();
    }
}