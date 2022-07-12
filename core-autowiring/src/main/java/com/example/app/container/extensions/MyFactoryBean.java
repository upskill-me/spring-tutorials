package com.example.app.container.extensions;

import com.example.app.Communicator;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Custom factory bean which itself returns instances of beans
 * {@link Communicator} in this case
 * FactoryBeans can implement *Aware interfaces to get access to global objects
 */
@Component
public class MyFactoryBean implements FactoryBean<FactoryBeanReturnedBean>, EnvironmentAware {

    private final FactoryBeanReturnedBean instance;

    private Environment environment;

    public MyFactoryBean() {
        this.instance = new FactoryBeanReturnedBean();
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("Set environment called");
    }

    @Override
    public FactoryBeanReturnedBean getObject() throws Exception {
        return this.instance;
    }

    @Override
    public Class<?> getObjectType() {
        return FactoryBeanReturnedBean.class;
    }


    @Override
    public boolean isSingleton() {
        return true;
    }
}
