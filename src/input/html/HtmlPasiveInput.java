package input.html;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpHeaders;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HtmlPasiveInput {
    public static void main(String[] args) throws FileNotFoundException {
        Vertx vertx = Vertx.vertx();
        Router router = Router.router(vertx);

        router.route().handler(BodyHandler.create());

        StringBuilder htmlContent = new StringBuilder();
        Scanner scan = new Scanner(new File("test\\pasive-input\\pasive-input-1.html"));

        while (scan.hasNextLine()) {
            htmlContent.append(scan.nextLine()).append('\n');
        }

        scan.close();

        String bodyContent = htmlContent.toString().split("<body>")[1].split("</body>")[0];
        // System.out.println(bodyContent);

        router.route("/").handler(routingContext -> {
            routingContext.response().putHeader("content-type", "text/html").end(bodyContent);
        });

        router.post("/response").handler(ctx -> {
            ctx.response().putHeader(HttpHeaders.CONTENT_TYPE, "text/plain");
            var pasiveInput = ctx.request().getParam("pasive_input");
            // System.out.println(pasiveInput);
            ctx.response().end("Event is being generated!");
            // System.out.println(pasiveInput);
            // here, the event must be generated
        });

        vertx.createHttpServer().requestHandler(router).listen(8080);
    }
}
