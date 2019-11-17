package expression_original_old;

public class ElementFactory {
    public static Element createElement(String type) {
        if (type.equals(Elements.button)) {
            return new Button();
        }
        return null;
    }

    public static void checkElementType(Element element) {
        if (element == null) {
            System.err.println("Error: element type not specified, cannot set name");
            try {
                throw new ElementNotCreatedException();
            } catch (ElementNotCreatedException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }
}
