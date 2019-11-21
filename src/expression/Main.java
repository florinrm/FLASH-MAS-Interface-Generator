package expression;


import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        Constructor constructor = new Constructor(Configuration.class);
        Yaml yaml = new Yaml();

        InputStream input = null;
        try {
            input = new FileInputStream(new File("test\\input1.yml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Configuration data = yaml.loadAs(input, Configuration.class);
        System.out.println(data);
        System.out.println(yaml.dump(data));
        // System.out.println(data.getConfiguration().get("div").getElements());

        String result = data.generate();
        System.out.println(result);
    }
}
