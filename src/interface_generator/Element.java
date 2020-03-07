package interface_generator;

import interface_generator.types.ElementType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Element {
    private String name;
    private List<Element> children = new ArrayList<>();
    private String type = ElementType.BLOCK.type;
    private Map<String, String> properties = new HashMap<>();
    private String text;

    public List<Element> getChildren() {
        return children;
    }

    public void setChildren(List<Element> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
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
                "name='" + name + '\'' +
                ", children=" + children +
                ", type='" + type + '\'' +
                ", properties=" + properties +
                ", text='" + text + '\'' +
                '}';
    }
}
