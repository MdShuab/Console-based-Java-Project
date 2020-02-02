package com.shuaib.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

	public static void main(String[] args) {
		
		ApplicationContext container=new ClassPathXmlApplicationContext("Spring-config.xml");
		MyBean mb=container.getBean(MyBean.class);
		mb.m1();
		

	}

}
