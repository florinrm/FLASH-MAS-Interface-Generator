package input.html;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class HtmlActiveInput {
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        if (!(engine instanceof Invocable)) {
            return;
        }

        Invocable inv = (Invocable) engine;
        var jsScripPath = "test/active-input/script.js";
        engine.eval("load('" + jsScripPath + "')");
    }
}
