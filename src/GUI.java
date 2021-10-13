import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GUI {
    Converter converter;
    public GUI(Converter converter) {
        this.converter = converter;
    }

    public void start() {
        // create base JFrame
        JFrame frame = new JFrame("Scuffedlang Translator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 200);
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


        // listeners for buttons
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the English they entered
                String text = input.getText();
                text = text.trim();
        
                // Display the translation
                output.setText(converter.convert(text));
            }
        });
        flipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get new input text
                String inText = output.getText();
                inText = inText.trim();
                if (inText.equals("Translation will appear here...")) inText = "";

                // Get new output text
                String outText = input.getText();
                outText = outText.trim();
                if (outText.equals("")) outText = "Translation will appear here...";
        
                // Flip the input and output text, and change converter mode
                output.setText(outText);
                input.setText(inText);

                converter.flip();
            }
        });
        


        frame.setVisible(true);
    }
}
