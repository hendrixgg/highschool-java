package NextExercises;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingCalculator extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 4414142236267681829L;
    JButton addBtn, subtractBtn, multiplyBtn, divideBtn, modBtn, clearBtn;
    JLabel firstNum, secondNum, result;
    JTextField num1, num2, answer;

    public SwingCalculator() {
        Container content = getContentPane();
        content.setLayout(new GridLayout(6, 2));

        setTitle("Swing Arithmetics");

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

        answer = new JTextField(15);
        answer.setEditable(false);
        content.add(answer);

        addBtn = new JButton("+");
        addBtn.addActionListener(this);
        content.add(addBtn);

        subtractBtn = new JButton("-");
        subtractBtn.addActionListener(this);
        content.add(subtractBtn);

        multiplyBtn = new JButton("*");
        multiplyBtn.addActionListener(this);
        content.add(multiplyBtn);

        divideBtn = new JButton("/");
        divideBtn.addActionListener(this);
        content.add(divideBtn);

        modBtn = new JButton("%");
        modBtn.addActionListener(this);
        content.add(modBtn);

        clearBtn = new JButton("CLEAR");
        clearBtn.addActionListener(this);
        content.add(clearBtn);

        pack();
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double val1;
        double val2;
        try {
            val1 = Double.parseDouble(num1.getText());
            val2 = Double.parseDouble(num2.getText());
            num1.setText("");
            num2.setText("");
            if (e.getSource() == addBtn) {
                answer.setText((val1 + val2) + "");
            } else if (e.getSource() == subtractBtn) {
                answer.setText((val1 - val2) + "");
            } else if (e.getSource() == multiplyBtn) {
                answer.setText((val1 * val2) + "");
            } else if (e.getSource() == divideBtn) {
                answer.setText((val1 / val2) + "");
            } else if (e.getSource() == modBtn) {
                answer.setText((val1 % val2) + "");
            } else {
                answer.setText("");
                num1.setText("");
                num2.setText("");
            }
        } catch (Exception ex) {
            if (e.getSource() != clearBtn)
                answer.setText("ERROR: input not valid");
            else
                answer.setText("");
            num1.setText("");
            num2.setText("");
        }
    }

    public static void main(String[] args) {
        new SwingCalculator();
    }
}