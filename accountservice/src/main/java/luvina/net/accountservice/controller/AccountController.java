/*
* Copyright(C) 2023 Luvina Software Company
* AccountController.java, August 21, 2023 dunghm
*/
package luvina.net.accountservice.controller;

import luvina.net.accountservice.model.Account;
import luvina.net.accountservice.model.Message;
import luvina.net.accountservice.model.Statistic;
import luvina.net.accountservice.serivce.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

/**
* Tạo các đầu api
* @author DungHM
*/
@CrossOrigin
@RestController
public class AccountController {
    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;
    @Autowired
    AccountService accountService;

    /**
     * Nhận request từ client và lưu vào database
     * Sau khi lưu thành công gủi message đến topic notification và statistic
     * @param account: data từ client
     * @return Account đã đăng ký
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Account account) {
        try {
            // Lưu vào database
            accountService.save(account);
            // Lấy thông tin account
            Statistic statistic = new Statistic();
            statistic.setMessage("Account " + account.getEmail() + " is created");
            statistic.setCreatedDate(new Date());
            // Tạo message
            Message message = new Message();
            message.setTo(account.getEmail());
            message.setToName(account.getUserName());
            message.setSubject("Welcome!!!");
            message.setContent("Account is created!!!");
            // Gửi message đến topic thông qua KafkaTemplate
            kafkaTemplate.send("notification", message);
            kafkaTemplate.send("statistic", statistic);
            return ResponseEntity.ok(account);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatusCode.valueOf(500)).body("error");
        }
    }
}
