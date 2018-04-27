package com.lyr.jms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Receive")
public class Receive extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Receive() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		
		try {
			InitialContext context = new InitialContext();
			
			Queue queue = (Queue)context.lookup("java:comp/env/queue/queue0");
			
			QueueConnectionFactory conFactory = (QueueConnectionFactory)context.lookup("java:comp/env/queue/connectionFactory");
		
			QueueConnection connection = (QueueConnection)conFactory.createConnection();
			
			QueueSession queueSession = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			
			QueueReceiver receiver = queueSession.createReceiver(queue);
			
			connection.start();
			
			TextMessage message = (TextMessage)receiver.receive();
			
			writer.write("Message Received: "+message.getText());
			
			connection.close();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doGet(req, resp);
	}

}
