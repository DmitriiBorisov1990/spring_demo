package com.borisov.bpp;

import com.borisov.hero.RandomValue;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.util.Arrays;
import java.util.Random;

@Component
public class RandomValueBeanPostProcessor implements BeanPostProcessor {

    private static Random RANDOM = new Random();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Arrays.stream(bean.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(RandomValue.class))
                .forEach(field -> {
                    RandomValue annotation = field.getAnnotation(RandomValue.class);
                    int min = annotation.min();
                    int max = annotation.max();
                    field.setAccessible(true); // доступ к private полям
                    ReflectionUtils.setField(field, bean, RANDOM.nextInt(max - min + 1));
                });
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
