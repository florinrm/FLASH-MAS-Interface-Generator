package old_interface_generator.expression;


import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Constructor constructor = new Constructor(Configuration.class);
        Yaml yaml = new Yaml();

        InputStream input = null;
        try {
            input = new FileInputStream(new File("test\\input2.yml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Configuration data = yaml.loadAs(input, Configuration.class);
        /*
        System.out.println(data);
        System.out.println(yaml.dump(data));
         */

        String result = data.generateHTML();
        System.out.println(result);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("test\\result.html"))) {
            writer.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
