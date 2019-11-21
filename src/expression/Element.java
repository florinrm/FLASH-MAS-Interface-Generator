package expression;

import java.util.ArrayList;
import java.util.List;

public class Element {
    // element type (button, list etc.)
    private String type;

    // name of element (name of a button)
    private String name;

    // value in element (the name put in button, like "Press!")
    private String value;

    // element text
    private String text;

    // list of elements (example: a div has more elements"
    private List<Element> elements = new ArrayList<>();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Element{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", text='" + text + '\'' +
                ", elements=" + elements +
                '}';
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
