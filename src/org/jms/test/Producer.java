package org.jms.test;

import java.util.Properties;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Producer {
	
	private static String queueName = "MyQueue";
	private static String connectionUrl = "tcp://localhost:61616";
	private static String initialContextFactory = "org.apache.activemq.jndi.ActiveMQInitialContextFactory";
	
	
	public static void main(String args[]){
		QueueConnection connection = null;
		Queue queue = null;
		QueueSession session = null;
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, initialContextFactory);
		properties.put(Context.PROVIDER_URL,connectionUrl);
		properties.put(Context.SECURITY_PRINCIPAL, "admin");
		properties.put(Context.SECURITY_CREDENTIALS, "admin");
		properties.put("queue." + queueName, queueName);
		try{
			InitialContext ctx = new InitialContext(properties);
			QueueConnectionFactory connectionFactory = (QueueConnectionFactory)ctx.lookup("QueueConnectionFactory");
			connection = connectionFactory.createQueueConnection();
			queue = (Queue) ctx.lookup(queueName);
			connection.start();
			session = connection.createQueueSession(true,Session.SESSION_TRANSACTED);
			//Destination destination = (Destination) ctx.lookup(queueName);
			QueueSender sender = session.createSender(queue);
			TextMessage message = session.createTextMessage();
			message.setText("Hello Activemq");
			sender.send(message);
			//sender.send(session.createBytesMessage());
			session.commit();
			connection.stop();
		}catch(Exception e){
			try {
				session.rollback();
			} catch (JMSException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		finally{
			try {
				connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}
