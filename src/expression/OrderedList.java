package expression;

enum OrderedListType {
    NUMERICAL, UPPERCASE, LOWERCASE, UPPERCASE_ROMAN, LOWERCASE_ROMAN
}

public class OrderedList extends AbstractList {
    private String type;
    private OrderedListType listType;
    public OrderedList() {
        super();
        listType = OrderedListType.NUMERICAL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public OrderedListType getListType() {
        return listType;
    }

    public void setListType(OrderedListType listType) {
        this.listType = listType;
    }

    @Override
    public String generate() {
        StringBuilder result = new StringBuilder("<ol>");
        Elements.indentLevel++;

        /*
        switch (listType) {
            case UPPERCASE:
                result += " type = \"A\"";
                break;
            case LOWERCASE:
                result += " type = \"a\"";
                break;
            case UPPERCASE_ROMAN:
                result += " type = \"I\"";
                break;
            case LOWERCASE_ROMAN:
                result += " type = \"i\"";
                break;
            case NUMERICAL:
                break;
        } */

        int counter = 1;
        for (String element: super.getListElements()) {
            result.append("\t".repeat(Elements.indentLevel));
            result.append(counter).append(". ").append(element).append("\n");
            ++counter;
        }
        Elements.indentLevel--;
        result.append("\n</ol>");
        return result.toString();
    }
}
