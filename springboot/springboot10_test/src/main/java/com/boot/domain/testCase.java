package com.boot.domain;

import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Alonso
 */
@Component
@Data
@ConfigurationProperties(prefix = "testcase.book")
public class testCase {

    private Integer id;
    private String name;
    private String type;
    private String context;
}
