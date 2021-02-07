package com.kafka.consumer;

import com.kafka.util.ProcessMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class KafkaConsumer {

    @Autowired
    ProcessMessage processMessage;

    private static final Logger LOGGER = LoggerFactory
            .getLogger(KafkaConsumer.class);

    private CountDownLatch latch = new CountDownLatch(2);

    @KafkaListener(topics = "applepi")
    public void receiveMessage(String message) {
        LOGGER.info("received message='{}'", message);
        // processMessage = new ProcessMessage();
        boolean flag =  processMessage.procesMessage(message);
        LOGGER.info("message has been processed ?"+flag);
        LOGGER.info("message has been processed successfully="+message);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}