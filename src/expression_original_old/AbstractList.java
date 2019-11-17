package expression_original_old;

import java.util.ArrayList;

public abstract class AbstractList implements Element {
    private ArrayList<String> listElements;

    AbstractList() {
        listElements = new ArrayList<>();
    }

    public void addElementInList(String element) {
        listElements.add(element);
    }

    ArrayList<String> getListElements() {
        return this.listElements;
    }

    @Override
    public abstract String generate();
}
