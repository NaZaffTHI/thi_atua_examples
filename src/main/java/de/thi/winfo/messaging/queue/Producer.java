package de.thi.winfo.messaging.queue;

import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/*
 * Example based on code delivered with ActiveMQ, located in folder:
 *  .../apache-activemq-5.14.0/examples/openwire/java/src/main/java/example
 */

public class Producer {
    public static void main(String[] args) throws JMSException {

        String messageBody = buildMessageBody();

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                ActiveMQConnection.DEFAULT_BROKER_URL
        );

        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue("ActiveMQTestQueue");

        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        int messages = 10000;
        for (int i = 1; i <= messages; i++) {
            TextMessage message = session.createTextMessage(messageBody);
            message.setIntProperty("id", i);
            producer.send(message);

            if (i % 1000 == 0) {
                System.out.printf("Sent %d messages%n", i);
            }
        }

        producer.send(session.createTextMessage("SHUTDOWN"));
        System.out.printf("Sent %d messages in total%n", messages + 1);
        connection.close();
    }

    private static String buildMessageBody() {
        int size = 256;
        String data = "abcdefghijklmnopqrstuvwxyz";

        StringBuilder body = new StringBuilder();
        for (int i = 0; i < size; i++) {
            body.append(data.charAt(i % data.length()));
        }
        return body.toString();
    }
}
