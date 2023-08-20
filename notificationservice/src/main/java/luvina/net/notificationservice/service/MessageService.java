/*
* Copyright(C) 2023 Luvina Software Company
* MessageService.java, August 21, 2023 dunghm
*/
package luvina.net.notificationservice.service;

import luvina.net.notificationservice.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
* Nhận message từ topic
* @author DungHM
*/
@Service
public class MessageService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private EmailService emailService;

    /**
     * Nhận message từ topic và gửi email
     * @param message: message từ topic
     */
    @KafkaListener(id = "notificationGroup", topics = "notification")
    public void listen(Message message) {
        logger.info("Received: ", message.getTo());
        emailService.sendEmail(message);
    }

}
