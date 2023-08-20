/*
* Copyright(C) 2023 Luvina Software Company
* Message.java, August 21, 2023 dunghm
*/
package luvina.net.accountservice.model;

import lombok.Data;

/**
* Tạo đối tượng để tạo message gửi đến topic
* @author DungHM
*/
@Data
public class Message {
    private String to;
    private String toName;
    private String subject;
    private String content;
}
