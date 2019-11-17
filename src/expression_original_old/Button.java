package expression_original_old;

public class Button implements Element {
    private String name;
    private String buttonType;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String generate() {
        StringBuilder result = new StringBuilder("<button");
        if (buttonType != null) {
            result.append(" type = \"").append(buttonType).append("\"");
        }
        if (value != null) {
            result.append(" value = \"").append(value).append("\"");
        }
        result.append(">\n");
        Elements.indentLevel++;

        result.append("\t".repeat(Elements.indentLevel));

        result.append(name);

        Elements.indentLevel--;
        result.append("\n</button>");
        return result.toString();
    }
}
