package com.adsima.spring.bpp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class AuditBeanPostProcessor implements BeanPostProcessor
{
    private final Map<String, Class<?>> auditBeans = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Audit.class)) {
            auditBeans.put(beanName, bean.getClass());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> aClass = auditBeans.get(beanName);
        if (aClass != null) {
            return Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), (proxy, method, args) -> {
                log.info("Audit bean: {}", beanName);
                try {
                    return method.invoke(bean, args);
                } finally {
                    log.info("Audit save");
                }
            });
        }
        return bean;
    }
}
