package com.borisov.bpp;

import com.borisov.hero.EnableProfiling;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProfilingBeanPostProcessor implements BeanPostProcessor {

    private Map<String,Object> beans = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(EnableProfiling.class)){
            beans.put(beanName,bean);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beans.containsKey(beanName)) {
            Object realBean = beans.get(beanName);
            Object proxy =  Enhancer.create(realBean.getClass(), (MethodInterceptor) (o, method, objects, methodProxy) -> {
                System.out.println("Профилирую....");
                long start = System.nanoTime();
                Object result = method.invoke(bean, objects);
                System.out.println(method.getName() + " выполнялся: " + (System.nanoTime() - start));
                return result;
            });
            return proxy;
        }
        return bean;
    }
}
