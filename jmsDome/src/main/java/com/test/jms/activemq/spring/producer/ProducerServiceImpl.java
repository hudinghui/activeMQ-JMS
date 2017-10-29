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
		//ͨ��spring�е�ʵ�ֵ�jmsTemplte��������Ϣ
		jmsTemplate.send(destination,new MessageCreator() {
			//����message��ͨ��session�Ự����
			public Message createMessage(Session session) throws JMSException {
				Message msg = session.createTextMessage(message);
				System.out.println("��Ϣ�ṩ�߷�����Ϣ�� "+message);
				return msg;
			}
		});

	}

}
