package com.example.spring.collections;

import com.example.spring.util.SpringBeanFactory;

public class App {

    public static void main(String[] args) {

        Person cust = (Person) SpringBeanFactory.getInstance().getBean("person");
        System.out.println(cust);

        Question question = (Question) SpringBeanFactory.getInstance().getBean("question");
        question.displayInfo();
    }
}
