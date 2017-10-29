package com.test.jms.activemq.spring.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ConsumerMessageListener implements MessageListener{

	public void onMessage(Message message) {
		// 处理接收到的信息（Message）
		try {
			System.out.println("监听队列消息: "+((TextMessage)message).getText());
			System.out.println("监听队列消息JMSType: "+message.getJMSType());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
