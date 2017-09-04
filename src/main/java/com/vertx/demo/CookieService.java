package com.vertx.demo;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Cookie;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.CookieHandler;

/**
 * 链接与RestDemo同
 * http://blog.csdn.net/janwen2010/article/details/72954158
 */
public class CookieService extends AbstractVerticle{

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(new CookieService());
    }

    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);
        router.route().handler(CookieHandler.create());
        router.route().handler(routingContext -> {
            Cookie cookie = routingContext.getCookie("testCookie");
            Integer c = 0;
            if (cookie != null){
                String count = cookie.getValue();
                try{
                    c = Integer.valueOf(count);
                }catch (Exception e){
                    e.printStackTrace();
                    c = 0;
                }
                c++;
            }
            routingContext.addCookie(Cookie.cookie("testCookie",String.valueOf(c)));
            routingContext.response().putHeader("content-type","text/html").end("total visit count:"+c);
        });

        vertx.createHttpServer().requestHandler(router::accept).listen(8000);
    }
}
