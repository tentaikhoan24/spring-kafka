/*
* Copyright(C) 2023 Luvina Software Company
* Message.java, August 21, 2023 dunghm
*/
package luvina.net.notificationservice.model;

import lombok.Data;

/**
* Tạo đối tợng message để nhận dữ liệu từ topic notification
* @author DungHM
*/
@Data
public class Message {
    private String to;
    private String toName;
    private String subject;
    private String content;
}
