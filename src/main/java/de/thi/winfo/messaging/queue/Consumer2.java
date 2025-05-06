package de.thi.winfo.messaging.queue;

import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Consumer2 {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                ActiveMQConnection.DEFAULT_BROKER_URL
        );

        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue("ActiveMQTestQueue");
        MessageConsumer consumer = session.createConsumer(destination);

        long start = System.currentTimeMillis();
        long count = 1;

        System.out.println("Consumer2 is waiting for messages...");

        while (true) {
            Message message = consumer.receive();
            if (message instanceof TextMessage textMessage) {
                String body = textMessage.getText();
                if ("SHUTDOWN".equals(body)) {
                    long timeDifference = System.currentTimeMillis() - start;
                    System.out.printf("Consumer1 received %d in %.2f seconds.", count, (1.0 * timeDifference / 1000.0));
                    break;
                } else {
                    System.out.println("Message with id " + textMessage.getIntProperty("id") + " received!");
                    if (count % 100 == 0) {
                        System.out.printf("Received %d messages.", count);
                    }
                    count++;
                }
            } else {
                System.out.println("Unexpected message type: " + message.getClass().getName());
            }
        }
        connection.close();
    }
}
