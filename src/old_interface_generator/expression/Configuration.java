package old_interface_generator.expression;

import java.util.LinkedHashMap;
import java.util.Map;

public class Configuration {
    private Map<String, InlineBlock> configuration = new LinkedHashMap<>();

    public Map<String, InlineBlock> getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Map<String, InlineBlock> configuration) {
        this.configuration = configuration;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "configuration=" + configuration +
                '}';
    }

    public String generateBody() {
        StringBuilder result = new StringBuilder();
        for (var line : configuration.entrySet()) {
            result.append("\t<div>\n");
            result.append(line.getValue().generateCode());
            result.append("\t</div>\n");
        }
        return result.toString();
    }

    public String generateHTML() {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">" +
                "<head>\n" +
                "\t<meta charset=\"UTF-8\">" +
                "\n<title>Page</title>\n" +
                "</head>\n" +
                "<body>\n" +
                generateBody() +
                "</body>";
    }
}
