package com.borisov.runner;

import com.borisov.dao.UserDao;
import com.borisov.hero.ano.HeroAno;
import com.borisov.hero.config.HeroConfig;
import com.borisov.hero.xml.Hero;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext contextXmlExample = new ClassPathXmlApplicationContext("application-context.xml");
        //ClassPathXmlApplicationContext contextAnoExample = new ClassPathXmlApplicationContext("annotaition-example.xml");
        AnnotationConfigApplicationContext contextConfExample = new AnnotationConfigApplicationContext(HeroConfig.class);
        Hero heroXmlExample = contextXmlExample.getBean("my_hero", Hero.class);
        System.out.println(heroXmlExample);
        //HeroAno heroAnoExample = contextAnoExample.getBean(HeroAno.class);
        //System.out.println(heroAnoExample);
        HeroAno bean = (HeroAno) contextConfExample.getBean("lego");
        System.out.println(bean);
        UserDao beanUserDao = (UserDao)contextConfExample.getBean("allUser");
        beanUserDao.findAll();
    }
}
