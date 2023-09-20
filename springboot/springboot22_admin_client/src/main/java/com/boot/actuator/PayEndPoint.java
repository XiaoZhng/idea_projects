package com.boot.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author Alonso
 */
@Component
@Endpoint(id = "pay", enableByDefault = true)
public class PayEndPoint {

    @ReadOperation
    public Object getPay(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("runTime", System.currentTimeMillis());
        map.put("name", "jack");
        map.put("age", "18");
        System.out.println("=============");
        return map;
    }
}
