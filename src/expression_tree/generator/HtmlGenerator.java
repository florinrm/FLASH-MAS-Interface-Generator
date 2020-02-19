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
                result.append(tab.repeat(indentLevel)).append("<div>\n");
                indentLevel++;
                for (var child : element.getChildren()) {
                    result.append(generate(child)).append('\n');
                }
                indentLevel--;
                result.append(tab.repeat(indentLevel)).append("</div>\n");
                break;
            case Types.BUTTON:
                result.append(tab.repeat(indentLevel)).append("<button>\n");
                indentLevel++;
                indentLevel--;
                result.append(tab.repeat(indentLevel)).append("</button>\n");
                break;

        }

        if (indentLevel == 1) {
            --indentLevel;
            result.append("</body>");
        }

        return result.toString();
    }
}
