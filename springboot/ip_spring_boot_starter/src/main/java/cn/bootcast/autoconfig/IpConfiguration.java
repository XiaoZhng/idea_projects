package cn.bootcast.autoconfig;

import cn.bootcast.service.IpCountService;
import org.springframework.context.annotation.Bean;

/**
 * @author Alonso
 */
public class IpConfiguration {

    @Bean
    public IpCountService ipCountService(){
        return new IpCountService();
    }
}
