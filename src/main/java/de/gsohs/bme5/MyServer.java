package de.gsohs.bme5;
import io.javalin.Javalin;

public class MyServer {
    public static void main(String[] args) {
        Javalin javalin = Javalin.create().start(8080);
        javalin.get("/hello", ctx -> ctx.result("Hello World!"));
        javalin.get("/greet/:name", ctx -> { ctx.result("Hello: " + ctx.pathParam("name")); });
        javalin.get("/myrequest", ctx -> ctx.result(ctx.header("key")));
        javalin.post("/formpost", ctx -> ctx.result(ctx.body()));
    }
}
