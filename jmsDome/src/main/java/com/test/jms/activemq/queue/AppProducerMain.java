package com.test.jms.activemq.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消息提供者服务类（队列模式）
 * @author Administrator
 *
 */
public class AppProducerMain {

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
		//创建生产者
		MessageProducer mp = session.createProducer(destination);
		
		for(int i=0;i<100;i++){
			//创建消息
			TextMessage tm = session.createTextMessage("test"+i);
			//s生产者发送消息
			mp.send(tm);
			System.out.println("test"+i+"已发送成功！");
		}
		
		//关闭连接
		//connection.close();
		
	}
}
