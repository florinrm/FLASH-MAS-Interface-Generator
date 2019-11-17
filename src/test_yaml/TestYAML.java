package test_yaml;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class TestYAML {
    public static void main(String[] args) {
        Constructor constructor = new Constructor(YamlConfig.class);
        Yaml yaml = new Yaml();

        InputStream input = null;
        try {
            input = new FileInputStream(new File("test\\test.yml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        YamlConfig data = yaml.loadAs(input, YamlConfig.class);
        System.out.println(data);
        System.out.println(yaml.dump(data));
    }
}
