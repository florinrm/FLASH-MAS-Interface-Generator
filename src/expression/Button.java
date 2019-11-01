package expression;

public class Button implements Element {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String generate() {
        StringBuilder result = new StringBuilder("<button>\n");
        Elements.indentLevel++;

        result.append("\t".repeat(Math.max(0, Elements.indentLevel)));
        result.append(name);

        Elements.indentLevel--;
        result.append("\n</button>");
        return result.toString();
    }
}
