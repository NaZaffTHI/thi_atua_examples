package de.thi.winfo.messaging.topic;

import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Publisher {
    public static void main(String[] args) throws JMSException {

        String messageBody = buildMessageBody();

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                ActiveMQConnection.DEFAULT_BROKER_URL
        );

        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic("ActiveMQTestTopic");
        MessageProducer publisher = session.createProducer(topic);
        publisher.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        int messages = 10000;
        for (int i = 1; i <= messages; i++) {
            TextMessage message = session.createTextMessage(messageBody);
            message.setIntProperty("id", i);
            publisher.send(message);

            if (i % 1000 == 0) {
                System.out.printf("Sent %d messages%n", i);
            }
        }

        publisher.send(session.createTextMessage("SHUTDOWN"));
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
