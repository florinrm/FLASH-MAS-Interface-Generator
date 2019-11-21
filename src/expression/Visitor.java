package expression;

public class Visitor {
    private int indentLevel = 0;
    private StringBuilder result = new StringBuilder();

    public void visit(Element element) {
        if (element.getType() == null) {
            return;
        }
        result.append("\t".repeat(indentLevel))
                .append('<')
                .append(element.getType());
        // TODO for name, value and others

        if (element.getName() != null) {
            result.append(" ")
                    .append("name = \"")
                    .append(element.getName())
                    .append("\"");
        }

        if (element.getValue() != null) {
            result.append(" ")
                    .append("value = \"")
                    .append(element.getValue())
                    .append("\"");
        }

        result.append(">\n");
        indentLevel++;

        for (var elem : element.getElements()) {
            elem.accept(this);
        }

        indentLevel--;

        result.append("\t".repeat(indentLevel))
                .append("</")
                .append(element.getType())
                .append(">\n");
    }

    public String getResult() {
        return result.toString();
    }

    public void setResult(StringBuilder result) {
        this.result = result;
    }
}
