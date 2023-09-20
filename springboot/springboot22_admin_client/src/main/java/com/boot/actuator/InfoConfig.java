package com.boot.actuator;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alonso
 */
@Component
public class InfoConfig implements InfoContributor {
    @Override
    public void contribute(Builder builder) {
        builder.withDetail("runtime", System.currentTimeMillis());
        Map<String, Object> map = new HashMap<>();
        map.put("buildTime", "2022.10.03");
        builder.withDetails(map);
    }
}
