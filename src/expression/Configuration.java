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

    public String generate() {
        String result = "";
        for (var element : configuration.entrySet()) {
            Visitor visitor = new Visitor();
            element.getValue().accept(visitor);
            result += visitor.getResult();
        }
        return result;
    }
}
