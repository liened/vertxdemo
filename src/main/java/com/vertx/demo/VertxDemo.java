package com.vertx.demo;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

/**
 * Hello world!
 *
 */
public class VertxDemo extends AbstractVerticle{

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new VertxDemo());
    }

    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);
        router.route().handler(routingContext -> {
           routingContext.response().putHeader("content-type","text/html").end("this is a vertx demo");
        });
        vertx.createHttpServer().requestHandler(router::accept).listen(8000);
    }
}
