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
 * ��Ϣ�����߷�����(����ģʽ)
 * @author Administrator
 *
 */
public class AppConsumerMain {
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
		//����һ��������
		MessageConsumer mc = session.createConsumer(destination);
		//����һ��������,��Ϣ������Ϣ����Ϣ�����Ǹ��첽���̣�
		mc.setMessageListener(new MessageListener() {
			
			public void onMessage(Message message) {
				// TODO Auto-generated method stub
				TextMessage tm = (TextMessage)message;
				try {
					System.out.println("�����߽��յ�����Ϣ�� "+tm.getText());
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		//�ر�����
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		connection.close();
		
	}
}
