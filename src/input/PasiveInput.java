package input;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpHeaders;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

public class PasiveInput {
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        Router router = Router.router(vertx);

        router.route().handler(BodyHandler.create());

        // TODO: example with spinner
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
