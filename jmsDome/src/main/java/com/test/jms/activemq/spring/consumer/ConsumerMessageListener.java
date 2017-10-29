package com.test.jms.activemq.spring.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ConsumerMessageListener implements MessageListener{

	public void onMessage(Message message) {
		// ������յ�����Ϣ��Message��
		try {
			System.out.println("����������Ϣ: "+((TextMessage)message).getText());
			System.out.println("����������ϢJMSType: "+message.getJMSType());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
