package old_interface_generator.expression_new;

import java.util.ArrayList;
import java.util.List;

public class Configuration {
    private List<Block> configuration = new ArrayList<>();

    public List<Block> getConfiguration() {
        return configuration;
    }

    public void setConfiguration(List<Block> configuration) {
        this.configuration = configuration;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "configuration=" + configuration +
                '}';
    }
}
