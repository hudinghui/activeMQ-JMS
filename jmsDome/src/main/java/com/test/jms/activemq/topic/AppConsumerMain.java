package com.test.jms.activemq.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消息消费者服务类(主题模式)
 * @author Administrator
 *
 */
public class AppConsumerMain {
	private static final String url = "tcp://127.0.0.1:61616";//61616为activeMq的默认端口
	private static final String queueName  = "queue-test";
	
	public static void main(String[] args) throws JMSException {
		//1、创建连接工厂ConnectionFctroy
		ConnectionFactory cf = new ActiveMQConnectionFactory(url);
		//2 创建连接Connection
		Connection connection = cf.createConnection();
		//3 启动连接
		connection.start();
		//创建回话
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//创建一个目标
		Destination destination = session.createQueue(queueName);
		//创建一个消费者
		MessageConsumer mc = session.createConsumer(destination);
		//创建一个监听器,消息队列消息（消息监听是个异步过程）
		mc.setMessageListener(new MessageListener() {
			
			public void onMessage(Message message) {
				// TODO Auto-generated method stub
				TextMessage tm = (TextMessage)message;
				try {
					System.out.println("消费者接收到的消息： "+tm.getText());
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		//关闭连接
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.close();
		
	}
}
