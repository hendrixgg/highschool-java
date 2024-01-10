package NextExercises;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingAdder extends JFrame implements ActionListener {
    
    /**
     *
     */
    private static final long serialVersionUID = 3256486850768288020L;
    JButton clearBtn, addBtn;
    JLabel firstNum, secondNum, result;
    JTextField num1, num2, sum;

    public SwingAdder() {
        Container content = getContentPane();
        content.setLayout(new GridLayout(4, 2));

        setTitle("SwingAdder");
        
        firstNum = new JLabel(" First Number");
        content.add(firstNum);

        num1 = new JTextField(20);
        content.add(num1);


        secondNum = new JLabel(" Second Number");
        content.add(secondNum);

        num2 = new JTextField(15);
        content.add(num2);

        result = new JLabel(" Result");
        content.add(result);

        sum = new JTextField(15);
        sum.setEditable(false);
        content.add(sum);

        addBtn = new JButton("ADD");
        addBtn.addActionListener(this);
        content.add(addBtn);

        clearBtn = new JButton("CLEAR");
        clearBtn.addActionListener(this);
        content.add(clearBtn);

        pack();
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearBtn) {
            num1.setText("");
            num2.setText("");
            sum.setText("");
        } else {
            try {
                double val1 = Double.parseDouble(num1.getText());
                double val2 = Double.parseDouble(num2.getText());
                sum.setText((val1 + val2) + "");
            } catch (Exception ex) {
                sum.setText("ERROR: inputs not numbers");
            }
            num1.setText("");
            num2.setText("");
        }

    }

    public static void main(String[] args) {
        new SwingAdder();
    }
}
