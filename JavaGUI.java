import javax.swing.*; //GUI components like buttons, frames, etc.
import java.awt.*; //Layouts and colors.
import java.awt.event.*; //Event handling like clicks, keypress, etc.

public class JavaGUI{
    public static void main(String[] args)
    {

        JFrame frame = new JFrame("GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);

    }
}