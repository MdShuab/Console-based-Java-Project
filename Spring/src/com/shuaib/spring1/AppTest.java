package com.shuaib.spring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext container=new ClassPathXmlApplicationContext("Spring-config.xml");
		Car c=container.getBean(Car.class);
		c.move();
	}

}
