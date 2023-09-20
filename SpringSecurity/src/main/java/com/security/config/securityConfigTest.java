package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

//创建配置类，设置使用哪个 UserDetailsService 实现类
@Configuration
public class securityConfigTest extends WebSecurityConfigurerAdapter {

    @Autowired
    protected UserDetailsService userDetailsService;

    @Autowired
    protected DataSource dataSource;

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        //jdbcTokenRepository.setCreateTableOnStartup(true); //会自动创建 persistent_logins表，存储自动登录的 cookie
        return jdbcTokenRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Bean
    PasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //用户注销
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/test/hello").permitAll();
        //配置没有权限访问跳转自定义页面
        http.exceptionHandling().accessDeniedPage("/unauth.html");
        http.formLogin() //自定义自己编写的登录页面
                .loginPage("/login.html") //登录页面设置
                .loginProcessingUrl("/user/login") //登录访问路径
//                .defaultSuccessUrl("/success.html")
                .failureUrl("/userLogin.html")
                .permitAll() //登录成功之后，跳转路径//登录失败跳转页面
                .and().authorizeRequests()
                .antMatchers("/", "/test/hello", "/user/login").permitAll() //设置哪些路径可以直接访问，不需要认证

                //  1.hasAuthority方法
                //当前登录用户，只有具有 admin权限才可以访问这个路径
                //.antMatchers("/test/index").hasAuthority("admin")

                //  2.hasAnyAuthority方法
                //.antMatchers("/test/index").hasAnyAuthority("admin", "manager")

                //  3.hasRole方法
                //.antMatchers("/test/index").hasRole("sale")

                //  4.hasAnyRole方法
                .antMatchers("/test/index").hasAnyRole("sale")

//                .anyRequest().authenticated()
                //配置自动登录
                .and().rememberMe().tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(60) // 设置有效时长，单位秒
                .userDetailsService(userDetailsService);
                //.and().csrf().disable(); //关闭csrf防护
    }
}
