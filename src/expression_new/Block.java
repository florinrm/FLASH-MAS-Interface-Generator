package expression_new;

import java.util.ArrayList;
import java.util.List;

public class Block {
    private List<Element> content;

    public Block(List<Element> content) {
        this.content = content;
    }

    public Block() {
        this.content = new ArrayList<>();
    }

    public List<Element> getContent() {
        return content;
    }

    public void setContent(List<Element> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Block{" +
                "content=" + content +
                '}';
    }
}
