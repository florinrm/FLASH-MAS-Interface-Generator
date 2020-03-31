package input.html;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileNotFoundException;

public class HtmlPasiveInput {
    public static void main(String[] args) throws FileNotFoundException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        if (!(engine instanceof Invocable)) {
            return;
        }

        Invocable inv = (Invocable) engine;
        var jsScripPath = "test/pasive-input/script.js";
    }
}
