package com.vertx.demo.spring;

import io.vertx.core.Vertx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 整个demo的启动类，负责启动spring容器，部署上面的两个模块，分别是spring模块和服务模块。
 * http://blog.csdn.net/janwen2010/article/details/72954162
 */
public class SpringMain {

    public static void main(String[] args) {
        // 注解方式配置，不需要配置文件
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        // 扫描哪些包内的注解
        ctx.scan("com.vertx.demo.spring");
        ctx.refresh();
        Vertx vertx = Vertx.vertx();
        //启动Spring模块
        vertx.deployVerticle(new WebVerticle(ctx));
        //部署服务器模块
        vertx.deployVerticle(new ServerVerticle());
    }
}
