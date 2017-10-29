package com.test.jms.activemq.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.jms.activemq.spring.producer.ProducerService;
import com.test.jms.activemq.spring.producer.ProducerServiceImpl;

/**
 * �����ṩ�߷���
 * @author Administrator
 *
 */
public class AppProducerMian {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
		ProducerService service = context.getBean(ProducerServiceImpl.class);
		service.sendMessage("sdf");
		//context.close();
	}
}
