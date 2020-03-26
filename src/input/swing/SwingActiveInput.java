package input.swing;

import interface_generator.PageBuilder;

import javax.swing.*;

public class SwingActiveInput {
    public static void main(String[] args) throws Exception {
        // creating some demo window for active input
        var page = PageBuilder.buildPage("test/active-input/swing-active-input-1.yaml");
        if (page instanceof JFrame) {
            var frame = (JFrame) page;
            frame.setVisible(true);

            var mainComponent = frame.getComponents()[0];
            if (mainComponent instanceof JRootPane) {
                var rootPanel = (JRootPane) mainComponent;
                var components = rootPanel.getComponents();
                for (var component : components) {
                    // System.out.println(component.getClass());
                    if (component instanceof JPanel) {
                        var panel = (JPanel) component;
                        /*
                        for (var comps: panel.getComponents()) {
                            System.out.println(comps.getClass());
                        }

                         */
                    }

                    if (component instanceof JLayeredPane) {
                        var panel = (JLayeredPane) component;
                        if (panel.getComponents().length == 1) {
                            var singleComp = panel.getComponents()[0];
                            if (singleComp instanceof JPanel) {
                                var componentPanel = (JPanel) singleComp;
                                for (var c : componentPanel.getComponents()) {
                                    System.out.println(c.getClass());
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
