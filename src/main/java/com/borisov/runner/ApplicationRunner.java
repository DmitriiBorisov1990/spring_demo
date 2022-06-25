package com.borisov.runner;

import com.borisov.config.DatabaseConf;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConf.class);
        Object dataSource = context.getBean("dataSource");
        System.out.println(dataSource);
    }
}
