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
 * ��Ϣ�ṩ�߷����ࣨ����ģʽ��
 * @author Administrator
 *
 */
public class AppProducerMain {

	private static final String url = "tcp://127.0.0.1:61616";//61616ΪactiveMq��Ĭ�϶˿�
	private static final String queueName  = "queue-test";
	
	public static void main(String[] args) throws JMSException {
		//1���������ӹ���ConnectionFctroy
		ConnectionFactory cf = new ActiveMQConnectionFactory(url);
		//2 ��������Connection
		Connection connection = cf.createConnection();
		//3 ��������
		connection.start();
		//�����ػ�
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//����һ��Ŀ��
		Destination destination = session.createQueue(queueName);
		//����������
		MessageProducer mp = session.createProducer(destination);
		
		for(int i=0;i<100;i++){
			//������Ϣ
			TextMessage tm = session.createTextMessage("test"+i);
			//s�����߷�����Ϣ
			mp.send(tm);
			System.out.println("test"+i+"�ѷ��ͳɹ���");
		}
		
		//�ر�����
		//connection.close();
		
	}
}
