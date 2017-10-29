package com.test.jms.activemq.spring.producer;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class ProducerServiceImpl implements ProducerService {

	@Autowired
	JmsTemplate jmsTemplate;
	@Resource
	Destination destination;
	
	public void sendMessage(final String message) {
		//通过spring中的实现的jmsTemplte来发送消息
		jmsTemplate.send(destination,new MessageCreator() {
			//创建message，通过session会话创建
			public Message createMessage(Session session) throws JMSException {
				Message msg = session.createTextMessage(message);
				System.out.println("消息提供者发送信息： "+message);
				return msg;
			}
		});

	}

}
