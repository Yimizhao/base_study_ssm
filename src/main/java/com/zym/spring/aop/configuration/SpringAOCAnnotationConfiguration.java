package com.zym.spring.aop.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages="com.zym.spring.aop.aspectj")
@EnableAspectJAutoProxy
public class SpringAOCAnnotationConfiguration {

}
