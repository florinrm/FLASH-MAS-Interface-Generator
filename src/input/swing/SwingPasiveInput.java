package input.swing;

import interface_generator.PageBuilder;
import interface_generator.generator.SwingGenerator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingPasiveInput {
    public static void main(String[] args) throws Exception {
        // creating some demo window for pasive input
        var page = PageBuilder.buildPage("test/pasive-input/swing-pasive-input-1.yaml");
        if (page instanceof JFrame) {
            var window = (JFrame) page;

            var element1 = SwingGenerator.getComponentById("spinner1", window);
            if (element1 instanceof JSpinner) {
                var spinner = (JSpinner) element1;
                var element2 = SwingGenerator.getComponentById("child1", window);
                if (element2 instanceof JButton) {
                    var button = (JButton) element2;
                    button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            var value = spinner.getValue();
                            System.out.println(value);
                        }
                    });
                }
            }
        }
    }
}
