package org.jms.test;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Consumer {
	
	private static String queueName = "MyQueue";
	private static String connectionUrl = "tcp://localhost:61616";
	private static String initialContextFactory = "org.apache.activemq.jndi.ActiveMQInitialContextFactory";
	
	public static void main(String args[]){
		QueueConnection connection = null;
		Queue queue = null;
		QueueSession session = null;
		TextMessage message = null;
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
			QueueReceiver receiver = session.createReceiver(queue);
			connection.start();
		//	while (true) {
			System.out.println("dddd");
                Message m = receiver.receive(100);
                System.out.println(m);
                if (m != null) {
                    if (m instanceof TextMessage) {
                        message = (TextMessage)m;
                        System.out.println("Consuming message: " + message.getText());
                   /* } else {
                        break;
                    } */
                }
            }
			System.out.println("sss");
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
				System.out.println("aaaa");
				connection.close();
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}
