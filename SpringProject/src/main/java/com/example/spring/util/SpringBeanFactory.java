/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.spring.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This PropertyfileLoader has been implemented as a singleton in order to avoid
 * having possibly a pool of trackers that need a synchronization protocol
 * within them, University of Maryland Computer Science researcher Bill Pugh has
 * written about the code issues underlying the Singleton pattern when
 * implemented in Java.(see
 * http://en.wikipedia.org/wiki/Singleton_pattern#The_solution_of_Bill_Pugh)
 * Pugh's efforts on the "Double-checked locking" idiom led to changes in the
 * Java memory model in Java 5 and to what is generally regarded as the standard
 * method to implement Singletons in Java The technique known as the
 * initialization on demand holder idiom, is as lazy as possible, and works in
 * all known versions of Java It takes advantage of language guarantees about
 * class initialization, and will therefore work correctly in all Java-compliant
 * compilers and virtual machines
 *
 * The inner class is referenced no earlier (and therefore loaded no earlier by
 * the class loader) than the moment that getInstance() is called Thus, this
 * solution is thread-safe without requiring special language constructs (i.e
 * volatile or synchronized).
 *
 * @author Jayasimha <jayasimha.bj@gmail.com>
 * @version 0.0.1
 *
 */
public class SpringBeanFactory {

    private final ApplicationContext applicationContext;

    private SpringBeanFactory() {
        applicationContext = new ClassPathXmlApplicationContext("spring/application-context.xml");
    }

    /**
     * Method avoids cloning for singleton class
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {

        throw new CloneNotSupportedException("PropertyFileLoader Cannot Be Cloned");
    }

    /**
     * Methods returns singleton instance.
     *
     * @return
     */
    public static synchronized SpringBeanFactory getInstance() {

        return SpringBeanFactoryHolder.INSTANCE;
    }

    /**
     * Returns a spring configured object given an id.
     *
     * @param id
     * @return Object, client needs to cast it to appropriate type.
     */
    public Object getBean(String id) {
        Object context = new Object();
        try {
            context = applicationContext.getBean(id);
        } catch (BeansException ex) {
            System.out.println(ex.getStackTrace());
        }
        return context;
    }

    /**
     *
     * /* This holder is used of a lazy initialization holder idiom in order to
     * avoid synchronization issues based on JLS
     * http://en.wikipedia.org/wiki/Initialization_on_demand_holder_idiom
     * NetBeans IDE shows a warning here saying: "Utility class without
     * constructor" but this is due to the implementation solution of the
     * singleton. This warning can be ignored.
     *
     */
    private static class SpringBeanFactoryHolder {

        static final SpringBeanFactory INSTANCE = new SpringBeanFactory();
    }

}
