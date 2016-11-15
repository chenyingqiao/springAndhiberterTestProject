package com.config.spring;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * Created by chen on 16-11-11.
 */
//说明这是一个配置文件
@Configuration
@EnableWebMvc
@ComponentScans(
        @ComponentScan("com.chen.controller")
)
public class SpringConfig {

    @Bean
    public BasicDataSource getDataSource(){
        BasicDataSource basicDataSource=new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql:///book_store");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("Cyq19931115");
        basicDataSource.setInitialSize(5);
        basicDataSource.setMaxActive(10);
        return basicDataSource;
    }

    /**
     * jsp视图解析器的bean
     * @return
     */
    @Bean
    public UrlBasedViewResolver setupViewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }
}
