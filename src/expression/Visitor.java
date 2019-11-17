package expression;

public class Visitor {
    private int indentLevel = 0;
    private StringBuilder result = new StringBuilder();

    public void visit(Element element) {
        result.append("\t".repeat(indentLevel))
                .append('<')
                .append(element.getType());
        // TODO for name, value and others
        result.append('>');
        indentLevel++;
        for (var elem : element.getElements()) {
            elem.accept(this);
        }
        indentLevel--;
        result.append("\t".repeat(indentLevel))
                .append("</")
                .append(element.getType())
                .append('>');
    }

    public String getResult() {
        return result.toString();
    }

    public void setResult(StringBuilder result) {
        this.result = result;
    }
}
