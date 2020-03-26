package input.swing;

import interface_generator.PageBuilder;

public class SwingPasiveInput {
    public static void main(String[] args) throws Exception {
        // creating some demo window for pasive input
        var page = PageBuilder.buildPage("test/pasive-input/swing-pasive-input-1.yaml");
    }
}
