package expression_original;

/*
    exception to be thrown when user specifies a value
    for element before the type of element (button) was created
 */
public class ElementNotCreatedException extends Exception {
    ElementNotCreatedException() {
        super("Element was not created");
    }

    public ElementNotCreatedException(String message) {
        super(message);
    }
}
