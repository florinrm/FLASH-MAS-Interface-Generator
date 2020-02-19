package expression_tree.generator;

import expression_tree.Element;
import expression_tree.Types;

public class HtmlGenerator {
    private static int indentLevel = 0;
    private final static String head = "<!DOCTYPE html>\n" +
            "    <html lang=\"en\">\n" +
            "    <head>\n" +
            "        <meta charset=\"UTF-8\">\n" +
            "    <title>Page</title>\n" +
            "    </head>\n" +
            "    <body>";

    public static String generate(Element element) {
        StringBuilder result = new StringBuilder();
        String tab = "\t";

        if (indentLevel == 0) {
            result.append(head).append('\n');
            indentLevel++;
        }

        switch (element.getType()) {
            case Types.BLOCK:
                if (element.getProperties() == null || element.getProperties().isEmpty()) {
                    result.append(tab.repeat(indentLevel)).append("<div>\n");
                } else {
                    result.append(tab.repeat(indentLevel)).append("<div ");
                    for (var pair : element.getProperties().entrySet()) {
                        result.append(pair.getKey())
                                .append(" = \"")
                                .append(pair.getValue())
                                .append('\"');
                    }
                    result.append(">\n");
                }
                indentLevel++;
                for (var child : element.getChildren()) {
                    result.append(generate(child)).append('\n');
                }
                indentLevel--;
                result.append(tab.repeat(indentLevel)).append("</div>\n");
                break;
            case Types.BUTTON:
                if (element.getProperties() == null || element.getProperties().isEmpty()) {
                    result.append(tab.repeat(indentLevel)).append("<button>\n");
                } else {
                    result.append(tab.repeat(indentLevel)).append("<button ");
                    for (var pair : element.getProperties().entrySet()) {
                        result.append(pair.getKey())
                                .append(" = \"")
                                .append(pair.getValue())
                                .append('\"');
                    }
                    result.append(">\n");
                }
                indentLevel++;
                if (element.getText() != null) {
                    result.append(tab.repeat(indentLevel)).append(element.getText()).append('\n');
                }
                indentLevel--;
                result.append(tab.repeat(indentLevel)).append("</button>\n");
                break;
            case Types.LABEL:
                if (element.getProperties() == null || element.getProperties().isEmpty()) {
                    result.append(tab.repeat(indentLevel)).append("<label>\n");
                } else {
                    result.append(tab.repeat(indentLevel)).append("<label ");
                    for (var pair : element.getProperties().entrySet()) {
                        result.append(pair.getKey())
                                .append(" = \"")
                                .append(pair.getValue())
                                .append('\"');
                    }
                    result.append(">\n");
                }
                indentLevel++;
                if (element.getText() != null) {
                    result.append(tab.repeat(indentLevel)).append(element.getText()).append('\n');
                }
                indentLevel--;
                result.append(tab.repeat(indentLevel)).append("</label>\n");
                break;
            case Types.FORM:
                if (element.getProperties() == null || element.getProperties().isEmpty()) {
                    result.append(tab.repeat(indentLevel)).append("<form>\n");
                } else {
                    result.append(tab.repeat(indentLevel)).append("<form ");
                    for (var pair : element.getProperties().entrySet()) {
                        result.append(pair.getKey())
                                .append(" = \"")
                                .append(pair.getValue())
                                .append('\"');
                    }
                    result.append(">\n");
                }
                indentLevel++;
                if (element.getText() != null) {
                    result.append(tab.repeat(indentLevel)).append(element.getText()).append('\n');
                }
                indentLevel--;
                result.append(tab.repeat(indentLevel)).append("</form>\n");
                break;
        }

        if (indentLevel == 1) {
            --indentLevel;
            result.append("</body>");
        }

        return result.toString();
    }
}
