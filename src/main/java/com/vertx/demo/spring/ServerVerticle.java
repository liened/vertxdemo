package com.vertx.demo.spring;

import io.vertx.core.AbstractVerticle;
import org.springframework.context.ApplicationContext;

/**
 * springVerticle作为事件总线中的后台处理程序，接收事件总线消息，并调用springService完成服务处理。
 */
public class ServerVerticle extends AbstractVerticle{

    private SpringService springService;

    public static final String GET_HELLO_MSG_SERVICE_ADDRESS = "get_hello_msg_service";

    public ServerVerticle(ApplicationContext ctx){
        this.springService = (SpringService)ctx.getBean("springService");
    }

    @Override
    public void start() throws Exception {
        // 唤起事件总线，注册一个事件处理者，或者直译叫事件消费者
        vertx.eventBus().consumer(GET_HELLO_MSG_SERVICE_ADDRESS).handler(msg->{
            // 获取事件内容后，调用service服务
            System.out.println("bus msg body is:"+msg.body());
            String helloMsg = springService.getHello();
            System.out.println("msg from hello service is:"+helloMsg);
            // 将service返回的字符串，回应给消息返回体
            msg.reply(helloMsg);
        });
    }
}
