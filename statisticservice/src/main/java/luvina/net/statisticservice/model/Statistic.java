/*
* Copyright(C) 2023 Luvina Software Company
* Statistic.java, August 21, 2023 dunghm
*/
package luvina.net.statisticservice.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

/**
* Tạo đối tợng để nhận data từ message trên topic và ghi vào database
* @author DungHM
*/
@Entity
@Table(name = "statistics")
@Data
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "message", columnDefinition = "VARCHAR(255)")
    private String message;
    @Column(name = "created_date")
    private Date createdDate;
}
