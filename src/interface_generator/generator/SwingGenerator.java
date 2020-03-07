package interface_generator.generator;

import interface_generator.Element;
import interface_generator.types.ElementType;

import javax.swing.*;
import java.awt.*;

public class SwingGenerator {
    public static JFrame generateWindow(Element element) {
        JFrame window = new JFrame();
        window.setSize(new Dimension(600, 600));
        JPanel windowPanel = new JPanel();
        windowPanel.setLayout(new BoxLayout(windowPanel, BoxLayout.X_AXIS));
        int x_axis = 0;
        if (element.getChildren() != null) {
            for (var child : element.getChildren()) {
                var panel = generate(child);
                /*
                panel.setAlignmentX(x_axis);
                x_axis += 1000;

                 */
                windowPanel.add(panel);
            }
        }
        window.add(windowPanel);
        return window;
    }

    public static JPanel generate(Element element) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        var type = ElementType.valueOfLabel(element.getType());
        if (type != null) {
            switch (type) {
                case BUTTON:
                    JButton button = new JButton();
                    if (element.getText() != null) {
                        button.setText(element.getText());
                    }
                    panel.add(button);
                    break;
                case LABEL:
                    JLabel label = new JLabel();
                    if (element.getText() != null) {
                        label.setText(element.getText());
                    }
                    panel.add(label);
                    break;
                case FORM:
                    JTextArea form = new JTextArea();
                    if (element.getText() != null) {
                        form.setText(element.getText());
                    }
                    // hack for a fixed size of form
                    form.setMaximumSize(new Dimension(100, 40));
                    form.setMinimumSize(new Dimension(100, 40));
                    panel.add(form);
                    break;
                case BLOCK:
                    JPanel subPanel = new JPanel();
                    subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.Y_AXIS));
                    if (element.getChildren() != null) {
                        for (var child : element.getChildren()) {
                            subPanel.add(generate(child));
                        }
                    }
                    panel.add(subPanel);
                    break;
            }
        }
        return panel;
    }
}
