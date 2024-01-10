package BasicExercises;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends JFrame implements ActionListener{

    

    /**
     *
     */
    private static final long serialVersionUID = 1182791873981L;
    JLabel inputLabel, sumLabel;
    JTextField inputField, sumField;
    long input, sum;
    
    public AWTAccumulator() {

        setTitle("AWT Accumulator");

        Container content = getContentPane();
        content.setLayout(new FlowLayout());

        inputLabel = new JLabel("Enter an integer");
        content.add(inputLabel);

        inputField = new JTextField();
        inputField.setColumns(20);
        inputField.addActionListener(this);
        content.add(inputField);

        sumLabel = new JLabel("The Accumulated sum is");
        content.add(sumLabel);

        sumField = new JTextField();
        sumField.setColumns(15);
        sumField.setEditable(false);
        content.add(sumField);

        setSize(400,100);
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        input = Long.parseLong(inputField.getText());
        inputField.setText("");
        sum += input;

        sumField.setText(sum + "");
    }

    public static void main(String[] args) {
        new AWTAccumulator();
    }
    
}
