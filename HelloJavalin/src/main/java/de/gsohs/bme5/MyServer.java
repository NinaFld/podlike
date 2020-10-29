package de.gsohs.bme5;

import io.javalin.Javalin;

import java.util.List;
import java.util.Map;


public class MyServer {
    public static void main(String[] args){
        Javalin javalin = Javalin.create().start(8080);
        javalin.get("/hello",ctx -> ctx.result("Hello World!"));
        javalin.get("/greet/:name", ctx -> { ctx.result("Hello: " + ctx.pathParam("name"));});
        javalin.get("/myrequest", ctx -> { ctx.result(ctx.protocol() + " " + ctx.headerMap());});

        javalin.post("/formpost", ctx -> {
            String out = "";
            for(Map.Entry<String, List<String>> form: ctx.formParamMap().entrySet()) {
                out += form.getKey()+" : "+form.getValue()+"\n";
            }
            ctx.result(out);
        });
        javalin.get("/thymeleaf", ctx -> {
            ctx.render("firsthtml.html", Map.of("fruits",new String[] {"apples","bananas","peaches"}));
        });
    }
}

