package BasicExercises;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AWTCounter extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 490095431458773934L;
    JButton btn;
    JLabel count;
    JTextField total;
    int sum;

    public AWTCounter() {

        setTitle("AWT Counter");

        Container content = getContentPane();
        content.setLayout(new FlowLayout());

        count = new JLabel("Counter");
        content.add(count);

        total = new JTextField(sum + "");
        total.setColumns(20);
        total.setEditable(false);
        content.add(total);

        btn = new JButton("Count");
        content.add(btn);
        btn.addActionListener(this);

        pack();
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sum++;

        total.setText(sum + "");
    }
    
    public static void main(String[] args) {
        new AWTCounter();
    }
}
