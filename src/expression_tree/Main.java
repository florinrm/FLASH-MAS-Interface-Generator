package expression_tree;

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
            input = new FileInputStream(new File("test\\input-tree.yaml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Configuration data = yaml.loadAs(input, Configuration.class);

        System.out.println(data.getNode());
        System.out.println(Generator.generate(data.getNode()));
    }
}
