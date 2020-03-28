package input.swing;

import interface_generator.PageBuilder;
import interface_generator.generator.SwingGenerator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingActiveInput {
    public static void main(String[] args) throws Exception {
        // creating some demo window for active input
        var page = PageBuilder.buildPage("test/active-input/swing-active-input-1.yaml");
        if (page instanceof JFrame) {
            var window = (JFrame) page;

            var element1 = SwingGenerator.getComponentById("form1", window);
            if (element1 instanceof JTextArea) {
                var form = (JTextArea) element1;
                var element2 = SwingGenerator.getComponentById("child1", window);
                if (element2 instanceof JButton) {
                    var button = (JButton) element2;
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // text to send to the agent
                            var text = form.getText();
                            System.out.println(text);
                        }
                    });
                }
            }
        }
    }
}
