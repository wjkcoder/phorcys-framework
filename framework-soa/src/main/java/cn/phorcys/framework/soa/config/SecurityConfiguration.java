package cn.phorcys.framework.soa.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/14 5:45 下午
 */
@Getter
@Setter
@Configuration
@ConfigurationProperties("phorcys.security")
public class SecurityConfiguration {
    private Long sessionExpiredSeconds = 3600L;
    private boolean checkLoginIPChange = true;
}
