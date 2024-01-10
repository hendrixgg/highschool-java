package Examples;

import javax.swing.*;

public class OptionDialogBox {
     
    public static void main(String []args){
        
        JFrame frame = new JFrame("Dialog box title"); //Declare a frame that will hold the dialog box
        frame.setVisible(true);
        frame.setSize(200, 200);
        Object[] options = {"Yes, please","No, thanks","No eggs, no ham!"}; //Create an array of options for the dialog box
        int n = JOptionPane.showOptionDialog(frame,"Want some?","A Silly Question",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,
                                             options,options[2]);
                                             
        System.out.println("You chose choice: " + n);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 1st choice = 0
        // 2nd choice = 1
        // 3rd choice = 2
    }
    
}
