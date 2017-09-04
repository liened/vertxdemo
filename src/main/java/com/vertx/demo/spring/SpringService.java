package com.vertx.demo.spring;

import org.springframework.stereotype.Component;

/**
 * http://blog.csdn.net/janwen2010/article/details/72954162
 */
@Component(value="springService")
public class SpringService {

    public String getHello(){
        return "hello spring";
    }

}
