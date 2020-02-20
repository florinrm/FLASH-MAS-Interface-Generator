package old_interface_generator.expression;

import java.util.LinkedHashMap;
import java.util.Map;

public class InlineBlock {
    private Map<String, Element> blockElements = new LinkedHashMap<>();

    public Map<String, Element> getBlockElements() {
        return blockElements;
    }

    public void setBlockElements(Map<String, Element> blockElements) {
        this.blockElements = blockElements;
    }

    public String generateCode() {
        String result = "";
        for (var element : blockElements.entrySet()) {
            Visitor visitor = new Visitor();
            visitor.setIndentLevel(2);
            element.getValue().accept(visitor);
            result += visitor.getResult();
        }
        return result;
    }
}
