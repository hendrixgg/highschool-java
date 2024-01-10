import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;

public class FractalTree extends Canvas {

  // fields for drawing
  private JFrame frame;
  private final int WINDOW_WIDTH = 1920;
  private final int WINDOW_HEIGHT = 1080;

  public FractalTree() {
    frame = new JFrame("Fractal Tree");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
    frame.setLocationRelativeTo(null);
    frame.setResizable(true);
    frame.add(this);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    FractalTree ft = new FractalTree();
    ft.setVisible(true);
    ft.setBackground(Color.black);
  }

  @Override
  public void paint(Graphics g) {
    g.setColor(Color.green);
    // drawFractalTree(g, WINDOW_WIDTH / 2, WINDOW_HEIGHT - 75, 90, 10);
    drawFlower(g, WINDOW_WIDTH / 2, WINDOW_HEIGHT - 50, 500, -Math.PI / 2, 5);
  }

  public void drawFractalTree(Graphics g, int x1, int y1, double angle, int depth) {
    if (depth == 0) {
    } else {
      int x2 = x1 - (int) (Math.cos(Math.toRadians(angle)) * depth * 10.0);
      int y2 = y1 - (int) (Math.sin(Math.toRadians(angle)) * depth * 10.0);

      Graphics2D g2d = (Graphics2D) g;
      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      g2d.setStroke(new BasicStroke(0.5f * depth));
      g2d.drawLine(x1, y1, x2, y2);

      drawFractalTree(g, x2, y2, angle + 30, depth - 1);
      drawFractalTree(g, x2, y2, angle - 30, depth - 1);
    }
  }

  public void drawFlower(Graphics g, double x1, double y1, int length, double angleRad, int level) {
    // INCOMPLETE - Write a recursive method to the flower as described
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    // g.drawString("Draw Flower Program", 40, 210);
    // erase the message above
    if (level > 0) {
      double x2 = x1 + length * Math.cos(angleRad);
      double y2 = y1 + length * Math.sin(angleRad);
      g2d.setStroke(new BasicStroke(0.5f * level));
      g.drawLine((int) (x1), (int) (y1), (int) (x2), (int) (y2));
      x1 = x2;
      y1 = y2;
      length *= 0.5;
      for (int i = -2; i < 3; i++) {
        drawFlower(g, x1, y1, length, angleRad + i * Math.PI / 6, level - 1);
      }
    }

  }
}