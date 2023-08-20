/*
* Copyright(C) 2023 Luvina Software Company
* EmailService.java, August 21, 2023 dunghm
*/
package luvina.net.notificationservice.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import luvina.net.notificationservice.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import java.nio.charset.StandardCharsets;

/**
* Tạo phương thức gửi email qua gmail server của google
* @author DungHM
*/
@Service
public class EmailService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private SpringTemplateEngine springTemplateEngine;
    @Value("${spring.mail.username}")
    private String from;

    /**
     * Phương thức gửi email
     * @param message
     */
    @Async
    public void sendEmail(Message message) {
        try {
            // ghi log len terminal cua chuong trinh
            logger.info("Start...sending mail!!!");
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.name());
            // Tao template email
            Context context = new Context();
            context.setVariable("name", message.getToName());
            context.setVariable("content", message.getContent());
            String html = springTemplateEngine.process("welcome", context);
            // Gui email
            helper.setTo(message.getTo());
            helper.setText(html, true);
            helper.setSubject(message.getSubject());
            helper.setFrom(String.valueOf(from));
            javaMailSender.send(mimeMessage);
            logger.info("End...email send success!!!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
