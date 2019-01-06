package com.test;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public final class SpringApplicationContext implements ApplicationContextAware {

	
    private static ApplicationContext context;

    public SpringApplicationContext() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        context = applicationContext;
    }

    /**
     * 获取ApplicationContext
     * 
     * @return
     */
    public static ApplicationContext getContext() {
        return context;
    }

    /**
     * 根据类名获取bean
     * 
     * @param beanType
     * @return
     */
    public static <T> T getBean(Class<T> beanType) {
        T t = getContext().getBean(beanType);
        return t;
    }

    /**
     * 根据beanId获取bean
     * 
     * @param beanId
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanId) {
        T t = (T) getContext().getBean(beanId);
        return t;
    }
}
