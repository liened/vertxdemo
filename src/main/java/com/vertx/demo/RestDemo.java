package com.vertx.demo;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

/**
 * http://blog.csdn.net/janwen2010/article/details/72954158
 *  SessionServer
 *  CookieServer
 */
public class RestDemo extends AbstractVerticle{

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new RestDemo());
    }

    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);
        router.route("/get/:param1/:param2").handler(this::getHandle);
        vertx.createHttpServer().requestHandler(router::accept).listen(8000);
    }

    public void getHandle(RoutingContext routingContext){
        String param1 = routingContext.request().getParam("param1");
        String param2 = routingContext.request().getParam("param2");
        JsonObject obj = new JsonObject();
        obj.put("method","get").put("param1",param1).put("param2",param2);
        routingContext.response().putHeader("content-type","application/json").end(obj.encodePrettily());
    }
}
