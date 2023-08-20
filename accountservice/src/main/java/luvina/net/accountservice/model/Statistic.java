/*
* Copyright(C) 2023 Luvina Software Company
* Statistic.java, August 21, 2023 dunghm
*/
package luvina.net.accountservice.model;

import lombok.Data;
import java.util.Date;

/**
* Tạo đối tượng để gửi đến topic
* @author DungHM
*/
@Data
public class Statistic {
    private String message;
    private Date createdDate;
}
