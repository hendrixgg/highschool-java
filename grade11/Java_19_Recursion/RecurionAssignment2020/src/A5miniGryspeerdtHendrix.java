import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Link to drawing with JFrame: <a title="mathbits.com" href=
 * "https://mathbits.com/MathBits/Java/Graphics/GraphingMethods.htm">mathbits.com</a>
 * 
 * @author Hendrix Gryspeerdt
 */
class A5 extends JFrame implements ActionListener {

    // Name-constants for the various dimensions
    public static final int CANVAS_WIDTH = 900;
    public static final int CANVAS_HEIGHT = 900;
    public static final Color CANVAS_BACKGROUND = Color.CYAN;

    private DrawCanvas canvas; // the custom drawing canvas (extends JPanel)

    // the buttons
    JButton btnQ1, btnQ2, btnQ3, btnExit;

    int progToRun;

    // timer to update the screen
    Timer timer;

    public A5() {

        // update the screen every 50 milliseconds
        timer = new Timer(50, this);
        progToRun = -1;

        // Set up a panel for the buttons
        JPanel btnPanel = new JPanel(null);
        btnPanel.setBackground(Color.WHITE);

        btnPanel.setPreferredSize(new Dimension(160, CANVAS_HEIGHT));

        btnQ1 = new JButton("Circle");
        btnPanel.add(btnQ1);
        btnQ1.addActionListener(this);
        btnQ1.setBounds(5, 300, 150, 30);

        btnQ2 = new JButton("Ruler");
        btnPanel.add(btnQ2);
        btnQ2.addActionListener(this);
        btnQ2.setBounds(5, 350, 150, 30);

        btnQ3 = new JButton("Flower");
        btnPanel.add(btnQ3);
        btnQ3.addActionListener(this);
        btnQ3.setBounds(5, 400, 150, 30);

        btnExit = new JButton("Exit");
        btnPanel.add(btnExit);
        btnExit.addActionListener(this);
        btnExit.setBounds(5, 450, 150, 30);

        // Set up a custom drawing JPanel
        canvas = new DrawCanvas();
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

        // Add both panels to this JFrame
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(canvas, BorderLayout.CENTER);
        cp.add(btnPanel, BorderLayout.EAST);

        // "this" JFrame fires KeyEvent

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Handle the CLOSE button
        setTitle("Assignment 6");
        pack(); // pack all the components in the JFrame
        setVisible(true); // show it
        requestFocus();

    }

    public void actionPerformed(ActionEvent e) {
        // check if restart button was pressed
        if (e.getSource() == btnQ1) {
            progToRun = 0;
        }
        // check if restart button was pressed
        else if (e.getSource() == btnQ2) {
            progToRun = 1;
        } else if (e.getSource() == btnQ3) {
            progToRun = 2;
        }

        // check if exit button was pressed
        else if (e.getSource() == btnExit) {
            System.exit(0);
        } else if (e.getSource() == timer) {
            canvas.repaint();
        }
    }

    /**
     * DrawCanvas (inner class) is a JPanel used for custom drawing
     */
    class DrawCanvas extends JPanel {

        int fHeight = CANVAS_HEIGHT;
        int fWidth = CANVAS_WIDTH;

        ////////////////////// ONLY MODIFY THE BODY OF THESE 3 METHODS BELOW
        ////////////////////// /////////////////////
        // Q1
        public void drawCircle(Graphics g, double radius, int num) {
            // COMPLETE - A recursive method to draw concentric circles
            
            // Turns on antialiasing so the lines look less jagged
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (num == 0) {
                g.drawString("Circle Tally: ", 40, 50);
            } else {
                // place a "1" under circle tally for each circle drawn.
                g.drawString("1", 30 + 10 * num, 70);
                // draw a circle centerd at (fwidth/2, fHeight/2) with the specified radius
                g.drawOval((int) (fWidth / 2 - radius), (int) (fHeight / 2 - radius), (int) (2 * radius),
                        (int) (2 * radius));
                // now draw another circle with half the radius and num - 1.
                drawCircle(g, radius / 2, num - 1);
            }
        }

        // Q2
        public void drawRuler(Graphics g, double x, double y, double w, double height) {
            // COMPLETE - A recursive method to draw a ruler as described

            // draws the middle tick mark centered at x + w/2
            g.drawLine((int) (x + w / 2), (int) (y + height), (int) (x + w / 2), (int) (y));
            // draw horizontal line at the base of the ruler
            g.drawLine((int) (x), (int) (y + height), (int) (x + w), (int) (y + height));

            // only draw additional tick marks with height greater than 50 pixels
            if (height > 50) {
                // draw all the smaller tick marks to the left of the drawn tick mark
                drawRuler(g, x, y + height / 2, w / 2, height / 2);
                // draw all the tick smaller marks to the right of the drawn tick mark
                drawRuler(g, x + w / 2, y + height / 2, w / 2, height / 2);
            }
        }

        // Q3
        public void drawFlower(Graphics g, double x1, double y1, int length, double angleRad, int level) {
            // COMPLETE - A recursive method to draw the flower as described

            // Turns on antialiasing so the lines look less jagged
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // terminates once level reaches 0
            if (level > 0) {
                // the coordinates for the second point of the branch are the original coordinates 
                // plus the (length of the branch) * sin(angleRad) or * cos(angleRad)
                double x2 = x1 + length * Math.cos(angleRad);
                double y2 = y1 + length * Math.sin(angleRad);
                // draws the branch line
                g.drawLine((int) (x1), (int) (y1), (int) (x2), (int) (y2));
                // sets the coordinates for the bases of the child branches to be the end of the parent branch
                x1 = x2;
                y1 = y2;
                // length is now divided by 2 so each child branch is half the length of the parent branch
                length /= 2;
                // draw the 5 child branches only if not on the last branch
                if (level > 1) {
                    // i represents the branch angle multiplier starting at -2 for the far left branch
                    // going up to 2 for the far right branch
                    for (int i = -2; i < 3; i++)
                        drawFlower(g, x1, y1, length, angleRad + i * Math.PI / 6, level - 1);
                }
            }

        }
        ////////////////////// ONLY MODIFY THE BODY OF THESE 3 METHODS ABOVE
        ////////////////////// /////////////////////

        public void paintComponent(Graphics g) {
            // erase the screen
            super.paintComponent(g);

            setBackground(CANVAS_BACKGROUND);

            // draw the desired program
            if (progToRun == 0) {
                // Set initial radius of circle
                int radius = CANVAS_WIDTH / 2;
                int num = 1;
                drawCircle(g, radius, num);
            }

            else if (progToRun == 1) {
                // draw ruler
                double h = CANVAS_HEIGHT / 2;
                double w = CANVAS_WIDTH;
                double x = 0;
                double y = 0;
                drawRuler(g, x, y, w, h);
            } else if (progToRun == 2) {
                // draw flower
                // Set initial startig location of one end of the branch (bottom middle)
                // indicate 5 levels of branches
                int levels = 5;
                int x1 = fWidth / 2;
                int y1 = fHeight;
                int length = CANVAS_WIDTH / 2;
                int y2 = CANVAS_HEIGHT / 2;
                double angleRad = -Math.PI / 2;

                drawFlower(g, x1, y1, length, angleRad, levels);
            }
        }
    }

    public static void main(String[] args) {
        A5 prog = new A5();
        prog.timer.start();
    }

}