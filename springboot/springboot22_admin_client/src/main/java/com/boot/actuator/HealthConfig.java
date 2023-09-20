package com.boot.actuator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alonso
 */
@Component
public class HealthConfig extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Builder builder) throws Exception {
        boolean condition = true;
        if (condition) {
            builder.status(Status.UP);
            builder.withDetail("runtime", System.currentTimeMillis());
            Map<String, Object> map = new HashMap<>();
            map.put("buildTime", "2022.10.03");
            builder.withDetails(map);
        }else {
            builder.status(Status.OUT_OF_SERVICE);
            builder.withDetail("程序状态", "异常");
        }
    }
}
