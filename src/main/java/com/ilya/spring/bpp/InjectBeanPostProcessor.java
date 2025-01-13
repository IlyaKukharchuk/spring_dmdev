package com.ilya.spring.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Arrays;

public class InjectBeanPostProcessor implements BeanPostProcessor, ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Processing bean: " + beanName);
        Arrays.stream(bean.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(InjectBean.class))
                .forEach(field -> {
                    System.out.println("Injecting into field: " + field.getName());
                    Object beanToInject = applicationContext.getBean(field.getType());
                    System.out.println("Bean to inject: " + beanToInject);
                    if (beanToInject == null) {
                        System.out.println("Bean to inject is null for field: " + field.getName());
                    } else {
                        System.out.println("Injecting bean: " + beanToInject + " into field: " + field.getName());
                    }
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, bean, beanToInject);
                });
        return bean;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
