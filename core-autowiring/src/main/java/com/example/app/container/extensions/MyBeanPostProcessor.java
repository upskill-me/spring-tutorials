package com.example.app.container.extensions;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * A bean is defined which is of type {@link BeanPostProcessor}
 * Such beans will be automatically registered with the ApplicationContext
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor, Ordered {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Post Process Before Initialization fired");
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Post Process After Initialization fired");
        return bean;
    }

    /**
     * The order of bean post processors in which they are fired can be defined by implementing {@link Ordered}
     * interface. All custom bean post processors will be sorted based on order before applying
     *
     * @return the order for this post processor
     */
    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }
}
