package expression;

public class Button implements Expression {
    private String name;

    @Override
    public String generate() {
        String result = "<button>";
        result += "</button>";

        return result;
    }
}
