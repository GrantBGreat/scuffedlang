import javax.swing.*;
import java.awt.*;
public class GUI {
    Converter converter;
    public GUI(Converter converter) {
        this.converter = converter;
    }

    public void start() {
        JFrame frame = new JFrame("Scuffedlang Translator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024,1024);
        frame.setLayout(new FlowLayout());

        // create input box
        JTextArea input = new JTextArea(5, 20);
        input.setLineWrap(true);
        input.setEditable(true);
        frame.add(input);


        //creates panel for the buttons
        JPanel buttons = new JPanel();
        buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));

        JButton convertButton = new JButton("Convert");
        buttons.add(convertButton);
        JButton flipButton = new JButton("Flip");
        buttons.add(flipButton);

        frame.add(buttons);

        // create output box
        JTextArea output = new JTextArea("Translation will appear here...", 5, 20);
        output.setLineWrap(true);
        output.setEditable(false);
        frame.add(output);

        frame.setVisible(true);
    }
}
