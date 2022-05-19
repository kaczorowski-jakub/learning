package com.os.udemy.ejb.test;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;

public class PostMessageToJMSQueue {

    public static final String JMS_CONNECTION_FACTORY = "jms/beanMgmtConnectionFactory";
    public static final String JMS_QUEUE_NAME = "jms/beanMgmtQueue";

    private QueueConnectionFactory qconFactory;
    private QueueConnection qcon;
    private QueueSession qsession;
    private QueueSender qsender;
    private Queue queue;
    private TextMessage msg;

    public void init(Context context, String queueName) throws Exception {
        this.qconFactory = (QueueConnectionFactory) context.lookup(JMS_CONNECTION_FACTORY);
        this.qcon = this.qconFactory.createQueueConnection();
        this.qsession = qcon.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        this.queue = (Queue) context.lookup(queueName);
        this.qsender = qsession.createSender(queue);
        msg = qsession.createTextMessage();
        qcon.start();
    }
    
    public void send(String message) throws Exception {
        msg.setText(message);
        qsender.send(msg);
    }
    
    public void close() throws Exception {
        qsender.close();
        qsession.close();
        qcon.close();
    }
    
    public static void main(String[] args) throws Exception {
        PostMessageToJMSQueue pm = new PostMessageToJMSQueue();
        pm.init(SessionBeanClient.getInitialContext(), JMS_QUEUE_NAME);
        pm.send("THIS IS ME - ALA - 2");
        pm.close();
    }
}
