package expression;

public class ElementFactory {
    public static Element createElement(String type) {
        if (type.equals(Elements.button)) {
            return new Button();
        }
        return null;
    }
}
