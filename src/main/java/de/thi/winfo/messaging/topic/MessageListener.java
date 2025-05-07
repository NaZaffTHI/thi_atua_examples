package de.thi.winfo.messaging.topic;

import jakarta.jms.*;

public class MessageListener implements jakarta.jms.MessageListener {
    private long count = 1;
    private boolean finishedReceiving = false;

    @Override
    public void onMessage(Message msg) {
        if (msg instanceof TextMessage) {
            String body = null;
            try {
                body = ((TextMessage) msg).getText();
            } catch (JMSException e) {
                e.printStackTrace();
            }

            if ("SHUTDOWN".equals(body)) {
                System.out.println(String.format("TopicMessageListener received %d messages in total.", count));
                this.finishedReceiving = true;
            } else {
                if (count % 100 == 0) {
                    System.out.println(String.format("Received %d messages.", count));
                }
            }
            count++;
        } else {
            System.out.println("Unexpected message type: " + msg.getClass());
        }
    }

    public boolean isFinishedReceiving() {
        return finishedReceiving;
    }
}
