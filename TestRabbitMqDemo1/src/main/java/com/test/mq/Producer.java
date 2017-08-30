package com.test.mq;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {
	
	public final static String QUEUE_NAME="myqueue";

	public static void main(String[] args) throws IOException, TimeoutException {
		// TODO Auto-generated method stub
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
      factory.setUsername("guest");
      factory.setPassword("guest");
      factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        String message = "Hello RabbitMQ";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
        System.out.println("Producer Send +'" + message + "'");
        channel.close();
        connection.close();

	}

}
