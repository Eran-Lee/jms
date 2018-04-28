package com.lyr.jms.servlet_pb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Subscribe")
public class Subscriber extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Subscriber() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		
		try {
			InitialContext context = new InitialContext();
			
			Topic topic = (Topic) context.lookup("java:comp/env/topic/topic0");
			
			TopicConnectionFactory conFactory = (TopicConnectionFactory)context.lookup("java:comp/env/topic/connectionFactory");
		
			TopicConnection connection = conFactory.createTopicConnection();
			
			TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
			
			TopicSubscriber subscriber = session.createSubscriber(topic);
			
			connection.start();
			
			TextMessage message = (TextMessage)subscriber.receive();
			
			writer.write("Message received:" + message.getText());
			
			connection.close();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
