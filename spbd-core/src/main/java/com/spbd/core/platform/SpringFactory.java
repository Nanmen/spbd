package com.spbd.core.platform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

public class SpringFactory {
    
    private ApplicationContext applicationContext;
    
    private static SpringFactory springFactory = null;
    
    private static Object LOCK = new Object();
    
    private SpringFactory() {
    }
    
    public static SpringFactory getInstance() {
    	synchronized (LOCK) {
    		if(springFactory == null) {
        		springFactory = new SpringFactory();
        	}
		}
    	return springFactory;
    }
    
    
    public void destroy() {
    	if(this.applicationContext != null) {
    		((AbstractApplicationContext)this.applicationContext).destroy();
    	}
    }
    
    public <T> T createBean(Class<T> beanClass) {
        return applicationContext.getAutowireCapableBeanFactory().createBean(beanClass);
    }
    
    public <T> T getOrCreateBean(Class<T> beanClass) { 
    	registerSingletonBean(StringUtils.uncapitalize(beanClass.getSimpleName()), beanClass);
    	return applicationContext.getBean(beanClass);
    }
    
    public <T> T getBean(Class<T> beanClass) {
        return applicationContext.getBean(beanClass);
    }
    
    public <T> T getNullableBean(Class<T> beanClass) {
    	try {
    		 return applicationContext.getBean(beanClass);
    	} catch (Exception e) {
    		return null;
    	}
    }
    
    public Object getBean(String beanName) {
    	return applicationContext.getBean(beanName);
    }
    
    public <T> T getBean(String beanName, Class<T> beanClass) {
    	return applicationContext.getBean(beanName, beanClass);
    }
    
    public <T> List<T> getBeans(Class<T> beanClass) {
        return new ArrayList<T>(applicationContext.getBeansOfType(beanClass).values());
    }
    
    public Resource[] getResources(String locationPattern) throws IOException {
    	return applicationContext.getResources(locationPattern);
    }
    
    @SuppressWarnings("unchecked")
    public <T> T initializeBean(T bean) {
        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();
        beanFactory.autowireBean(bean);
        return (T) beanFactory.initializeBean(bean, bean.getClass().getName());
    }
    
    /**
     * register bean definition with singleton scope, when the definition has existed, do nothing, or register it
     * @param beanName
     * @param beanClass
     */
    public void registerSingletonBean(String beanName, Class<?> beanClass) {
    	BeanDefinitionRegistry beanRegistry = (BeanDefinitionRegistry)applicationContext.getAutowireCapableBeanFactory();
    	try {
    		beanRegistry.getBeanDefinition(beanName);
    		return;
    	} catch (Exception e) {
    		GenericBeanDefinition definition =  new GenericBeanDefinition();
    		definition.setBeanClass(beanClass);
            definition.setScope(BeanDefinition.SCOPE_SINGLETON);
            beanRegistry.registerBeanDefinition(beanName, definition);
    	}
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        Assert.isTrue(applicationContext.getAutowireCapableBeanFactory() instanceof BeanDefinitionRegistry, "autowireCapableBeanFactory should be BeanDefinitionRegistry");
    }
}