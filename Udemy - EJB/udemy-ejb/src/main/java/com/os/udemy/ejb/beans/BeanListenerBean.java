package com.os.udemy.ejb.beans;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven Bean implementation class for: BeanListenerBean
 */
@MessageDriven(name = "testMDB", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "connectionFactoryJndiName", propertyValue = "jms/beanMgmtConnectionFactory"),
        @ActivationConfigProperty(propertyName = "destinationJndiName", propertyValue = "jms/beanMgmtQueue")})
public class BeanListenerBean implements MessageListener {

    /**
     * Default constructor.
     */
    public BeanListenerBean() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        try {
            System.out.println("Message received: " + tm.getText());
        } catch (Exception e) {
            
        }
    }

}
