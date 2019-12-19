package expression_new;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Constructor constructor = new Constructor(Configuration.class);
        Yaml yaml = new Yaml();

        InputStream input = null;
        try {
            input = new FileInputStream(new File("test\\test.yaml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Configuration data = yaml.loadAs(input, Configuration.class);

        System.out.println(data.getConfiguration());
    }
}
