package input.html;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpHeaders;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HtmlActiveInput {
    public static void main(String[] args) throws FileNotFoundException {
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

        StringBuilder htmlContent = new StringBuilder();
        // TODO: read HTML file and take body
        Scanner scan = new Scanner(new File("test\\active-input\\active-input-1.html"));

        while (scan.hasNextLine()) {
            htmlContent.append(scan.nextLine()).append('\n');
        }

        scan.close();

        String bodyContent = htmlContent.toString().split("<body>")[1].split("</body>")[0];
        System.out.println(bodyContent);

        /*
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
         */

        router.route("/").handler(routingContext -> {
            routingContext.response().putHeader("content-type", "text/html").end(bodyContent);
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
