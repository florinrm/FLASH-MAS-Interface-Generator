package expression;

import java.util.LinkedHashMap;
import java.util.Map;

public class Configuration {
    private Map<String, Element> configuration = new LinkedHashMap<>();

    public Map<String, Element> getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Map<String, Element> configuration) {
        this.configuration = configuration;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "configuration=" + configuration +
                '}';
    }
}
