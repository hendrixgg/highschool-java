import javax.swing.*; //make sure you import this library!
import java.awt.*;

class IntroToSwing {
    public static void main(String[] args) {
        /*
         * Lets start learning about JFrames! A JFrame is a top-level window with a
         * title and a border.
         */
        // 1. Create the JFrame.
        // we are creating an object from the JFrame class called frame and passing it
        // the value FrameDemo
        JFrame frame = new JFrame("FrameDemo");
        
        // 2. Optional: What happens when the frame closes?
        // this line of code causes the entire program to close when the window closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. Create components and put them in the frame.
        // ...create emptyLabel...
        // create object emptylabel from class JLabel and pass it nothing
        JLabel sampleLabel = new JLabel("My Label");
        JButton sampleButton = new JButton("The Button");

        // get the container of the frame
        Container content = frame.getContentPane();
        content.setLayout(new FlowLayout());

        // add this label to the container
        content.add(sampleLabel);
        content.add(sampleButton);

        // 4. Size the frame.
        // this code adjusts the size of the frame and fit the components within the
        // frame.
        frame.setPreferredSize(new Dimension(500, 500));
        frame.pack();

        // 5. Display the JFrame.
        frame.setVisible(true);
    }
}