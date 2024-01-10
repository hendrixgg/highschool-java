package NextExercises;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AWTCounter2 extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 490095431458773934L;
    JButton increase, decrease, reset;
    JLabel count;
    JTextField total;
    int sum;

    public AWTCounter2() {

        setTitle("AWT Counter v2");

        Container content = getContentPane();
        content.setLayout(new FlowLayout());

        count = new JLabel("Counter");
        content.add(count);

        total = new JTextField(sum + "");
        total.setColumns(20);
        total.setEditable(false);
        content.add(total);

        increase = new JButton("Count Up");
        content.add(increase);
        increase.addActionListener(this);

        decrease = new JButton("Count Down");
        content.add(decrease);
        decrease.addActionListener(this);

        reset = new JButton("Reset");
        content.add(reset);
        reset.addActionListener(this);

        pack();
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == increase) {
            sum++;
        } else if (e.getSource() == decrease) {
            sum--;
        } else if (e.getSource() == reset) {
            sum = 0;
        }
        total.setText(sum + "");
    }
    
    public static void main(String[] args) {
        new AWTCounter2();
    }
}
