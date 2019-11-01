package expression;

public class ElementNotCreatedException extends Exception {
    public ElementNotCreatedException() {
        super("Element was not created");
    }

    public ElementNotCreatedException(String message) {
        super(message);
    }
}
