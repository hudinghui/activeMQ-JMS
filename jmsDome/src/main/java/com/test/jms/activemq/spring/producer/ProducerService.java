package com.test.jms.activemq.spring.producer;

/**
 * 消息提供发布者
 * @author Administrator
 *
 */
public interface ProducerService {

	//发送文本信息
	void sendMessage(String message);
}
