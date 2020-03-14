package input;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.TemplateHandler;
import io.vertx.ext.web.templ.rocker.RockerTemplateEngine;
import io.vertx.ext.web.templ.thymeleaf.ThymeleafTemplateEngine;

import javax.script.ScriptException;
import java.io.IOException;

public class ActiveInput {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        Router router = Router.router(vertx);

        // using thymeleaf
        /*
        ThymeleafTemplateEngine engine = ThymeleafTemplateEngine.create(vertx);
        router.get().handler(ctx -> {
            // we define a hardcoded title for our application
            JsonObject data = new JsonObject()
                    .put("welcome", "Hi there!");
            // and now delegate to the engine to render it.
            engine.render(data, "templates/index.html", res -> {
                System.out.println(res.succeeded());
                if (res.succeeded()) {
                    ctx.response().end(res.result());
                    System.out.println("kek");
                } else {
                    ctx.fail(res.cause());
                }
            });
        });
        // start a HTTP web server on port 8080
        vertx.createHttpServer().requestHandler(router).listen(8080);
         */

        router.route().handler(BodyHandler.create());

        router.route("/").handler(routingContext -> {
            routingContext.response().putHeader("content-type", "text/html").end(
                    "<form action=\"/response\" method=\"post\">\n" +
                            "    <div>\n" +
                            "        <label for=\"name\">Enter data</label>\n" +
                            "        <input type=\"text\" id=\"active_input\" name=\"active_input\" />\n" +
                            "    </div>\n" +
                            "    <div class=\"button\">\n" +
                            "        <button type=\"submit\">Send data to agent</button>\n" +
                            "    </div>" +
                            "</form>"
            );
        });

        router.post("/response").handler(ctx -> {
            ctx.response().putHeader(HttpHeaders.CONTENT_TYPE, "text/plain");
            var activeInput = ctx.request().getParam("active_input");
            // System.out.println(activeInput[0]);
            ctx.response().end("Event is being generated!");
            System.out.println(activeInput);
            // here, the event must be generated
        });

        vertx.createHttpServer().requestHandler(router).listen(8080);
    }
}
