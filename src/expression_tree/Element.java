package expression_tree;

import expression_tree.properties.Property;

import java.util.ArrayList;
import java.util.List;

public class Element {
    private String name;
    private List<Element> children = new ArrayList<>();
    private String type = Types.BLOCK;
    private List<Property> properties = new ArrayList<>();

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

    @Override
    public String toString() {
        return "Element{" +
                "name='" + name + '\'' +
                ", children=" + children +
                ", type='" + type + '\'' +
                '}';
    }
}
