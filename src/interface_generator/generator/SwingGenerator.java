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
        windowPanel.setLayout(new BoxLayout(windowPanel, BoxLayout.Y_AXIS));
        // windowPanel.putClientProperty(element.getId(), null);
        if (element.getChildren() != null) {
            for (var child : element.getChildren()) {
                var panel = generate(child);
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
                    panel.putClientProperty(element.getId(), button);
                    System.out.println(panel.getComponents().length);
                    System.out.println(panel.getComponents()[0].getClass());
                    break;
                case LABEL:
                    JLabel label = new JLabel();
                    if (element.getText() != null) {
                        label.setText(element.getText());
                    }
                    panel.add(label);
                    panel.putClientProperty(element.getId(), label);
                    System.out.println(panel.getComponents().length);
                    System.out.println(panel.getComponents()[0].getClass());
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
                    panel.putClientProperty(element.getId(), form);

                    System.out.println(panel.getComponents().length);
                    System.out.println(panel.getComponents()[0].getClass());
                    break;
                case BLOCK:
                    JPanel subPanel = new JPanel();
                    subPanel.setLayout(new BoxLayout(subPanel, BoxLayout.X_AXIS));
                    if (element.getChildren() != null) {
                        for (var child : element.getChildren()) {
                            subPanel.add(generate(child));
                        }
                    }
                    panel.add(subPanel);
                    panel.putClientProperty(element.getId(), subPanel);
                    break;
            }
        }
        return panel;
    }

    public static Object getComponentById(String id, JFrame frame) {
        var contentPane = frame.getRootPane().getContentPane();
        if (contentPane instanceof JPanel) {
            var windowsPanel = (JPanel) contentPane;
            var mainComponent = windowsPanel.getComponents()[0];

            if (mainComponent instanceof JPanel) {
                var mainPanel = (JPanel) mainComponent;
                return getComponentById(id, mainPanel);
            } else {
                return null;
            }
        }

        return null;
    }

    // TODO: recursive search
    private static Object getComponentById(String id, JPanel panel) {
        var result = panel.getClientProperty(id);
        if (result != null) {
            return result;
        }

        var components = panel.getComponents();
        for (var component : components) {
            if (component instanceof JPanel) {
                return getComponentById(id, (JPanel) component);
            }
        }

        return null;
    }
}
