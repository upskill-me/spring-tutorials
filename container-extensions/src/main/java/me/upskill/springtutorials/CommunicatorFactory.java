package me.upskill.springtutorials;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Custom factory bean which itself returns instances of beans
 * {@link Communicator} in this case
 * FactoryBeans can implement *Aware interfaces to get access to global objects
 * <p>
 * Component here is supplied with a value this value indicate the bean name
 * which can be used to get access to communicator bean from application context using getBean method
 * <p>
 * Using autowiring we can directly inject communicator bean to any other bean
 * We have learned that autowiring uses by type semantics by default
 *
 * <code>
 * public class BeanA {
 *
 *     @Autowired
 *     private Communicator communicator
 * }
 * </code>
 */
@Component("communicator")
public class CommunicatorFactory implements FactoryBean<Communicator>, EnvironmentAware, ApplicationContextAware,
        InitializingBean, DisposableBean {

    private final Communicator instance;

    private Environment environment;

    private ApplicationContext applicationContext;

    public CommunicatorFactory() {
        this.instance = new Communicator();
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("Set environment called");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public Communicator getObject() throws Exception {
        // since communicator has some fields which needs to be autowired let us do that
        return this.instance;
    }

    @Override
    public Class<?> getObjectType() {
        return Communicator.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    /// these initialization methods means that spring IoC container is only managing the lifecycle of this
    // factory bean and not the lifecycle of objects produced by this factory bean

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy method called on factory bean. We should clean up the instance here");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Init method called on factory bean. We should do any initialization here");
        applicationContext.getAutowireCapableBeanFactory().autowireBean(this.instance);
    }
}
