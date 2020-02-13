package expression_tree;

public class Generator {
    private static int indentLevel = 0;

    public static String generate(Element element) {
        StringBuilder result = new StringBuilder();
        String tab = "\t";
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
        return result.toString();
    }
}
