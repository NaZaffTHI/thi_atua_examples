package de.thi.winfo.messaging.topic;

import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/*
 * Example based on code delivered with ActiveMQ, located in folder:
 *  .../apache-activemq-5.14.0/examples/openwire/java/src/main/java/example
 */

public class AsyncSubscriber {
    public static void main(String[] args) throws JMSException, InterruptedException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                ActiveMQConnection.DEFAULT_BROKER_URL
        );

        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("ActiveMQTestTopic");

        MessageConsumer subscriber = session.createConsumer(topic);

        // Setting MessageListener instead of receive-method!!!
        MessageListener messageListener = new MessageListener();
        subscriber.setMessageListener(messageListener);

        System.out.println("Async Subscriber is ready, waiting for messages...");
        System.out.println("press Ctrl+c to shutdown...");

        // In case the server should run forever, the following lines are superfluous
        // Now the server stops whenever a SHUTDOWN message is received (see TopicMessageListener.java)
        while(!messageListener.isFinishedReceiving()){
            Thread.sleep(1000);
            System.out.println("Async Subscriber still working...");
        }
        System.out.println("Async Subscriber ends!");
        System.exit(0);
    }
}
