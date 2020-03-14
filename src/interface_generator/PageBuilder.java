package interface_generator;

import interface_generator.generator.AndroidGenerator;
import interface_generator.generator.HtmlGenerator;
import interface_generator.generator.SwingGenerator;
import interface_generator.types.PlatformType;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import javax.swing.*;
import java.io.*;

public class PageBuilder {
    public static void main(String[] args) throws Exception {
        // building the page

        Constructor constructor = new Constructor(Configuration.class);
        Yaml yaml = new Yaml();

        InputStream input = null;
        try {
            input = new FileInputStream(new File("test\\model\\input-swing.yaml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Configuration data = yaml.loadAs(input, Configuration.class);

        var platformType = data.getPlatformType();
        var type = PlatformType.valueOfLabel(platformType);

        if (type != null) {
            switch (type) {
                case HTML:
                    var html = HtmlGenerator.generate(data.getNode());
                    System.out.println(html);
                    FileWriter fileWriter = new FileWriter("test\\generated-pages\\page.html");
                    PrintWriter printWriter = new PrintWriter(fileWriter);
                    printWriter.print(html);
                    printWriter.close();
                    break;
                case ANDROID:
                    var android = AndroidGenerator.generate(data.getNode());
                    System.out.println(android);
                    break;
                case DESKTOP:
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException
                            | InstantiationException
                            | IllegalAccessException
                            | UnsupportedLookAndFeelException ex) {
                        ex.printStackTrace();
                    }
                    var frame = SwingGenerator.generateWindow(data.getNode());
                    frame.setVisible(true);
                    break;
            }
        }
    }
}
