# How to run messaging examples

The examples in this package relay on a third party software, that helps to manage the messages sent between client and server.

There are a lot of software tools for that purpose on the market, for example in the Amazon Web Services Cloud (Amazon SQS, Amazon SNS) or - in this example - **ActiveMQ from Apache** (also available in the cloud as Amazon MQ).   
ActiveMQ is a so called Message Broker, that fully implements the Java Message Service (JMS, today renamed to "Jackarta Messaging)

For this example you have to download ActiveMQ from the link below and run it locally.  
https://activemq.apache.org/

Details on how to install and run ActiveMQ on your operating system can be found online or on your favorite LLM.

After starting ActiveMQ, you can start the example code in these packages. 
Usually you start the Clients (Consumer and Subscriber) before the Server (Producer, Publisher).
