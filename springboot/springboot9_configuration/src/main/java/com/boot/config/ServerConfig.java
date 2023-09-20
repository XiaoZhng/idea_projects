package com.boot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @author Alonso
 */

//@Component
@Data
@ConfigurationProperties(prefix = "server")
//2.开启对当前bean的属性注入校验
@Validated
public class ServerConfig {
    private String ipAddress;
    //3.设置校验规则
    @Max(value = 8890, message = "最大值不能超过8890")
    @Min(value = 200, message = "最小值不能超过200")
    private Integer port;
    private long timeout;
    //时间计量单位
    @DurationUnit(ChronoUnit.HOURS)
    private Duration serverTimeOut;
    //空间计量单位
    @DataSizeUnit(DataUnit.KILOBYTES)
    private DataSize dataSize;
}
