package interface_generator;

import interface_generator.generator.AndroidGenerator;
import interface_generator.generator.HtmlGenerator;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;

public class PageBuilder {
    public static void main(String[] args) throws Exception {
        // building the page

        Constructor constructor = new Constructor(Configuration.class);
        Yaml yaml = new Yaml();

        InputStream input = null;
        try {
            input = new FileInputStream(new File("test\\model\\input-tree-2.yaml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Configuration data = yaml.loadAs(input, Configuration.class);

        // System.out.println(data.getNode());
        if (data.getPlatformType().equals(Types.HTML)) {
            var html = HtmlGenerator.generate(data.getNode());
            System.out.println(html);
            FileWriter fileWriter = new FileWriter("test\\pages\\page.html");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(html);
            printWriter.close();
        } else if (data.getPlatformType().equals(Types.ANDROID)) {
            var android = AndroidGenerator.generate(data.getNode());
            System.out.println(android);
        }
    }
}
