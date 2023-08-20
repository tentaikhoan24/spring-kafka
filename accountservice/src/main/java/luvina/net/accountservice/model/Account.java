/*
* Copyright(C) 2023 Luvina Software Company
* Account.java, August 21, 2023 dunghm
*/
package luvina.net.accountservice.model;

import jakarta.persistence.*;
import lombok.Data;

/**
* Tạo đối tương entity
* @author DungHM
*/
@Entity
@Table(name = "accounts")
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "user_name", columnDefinition = "VARCHAR(255)")
    private String userName;
    @Column(name = "password", columnDefinition = "VARCHAR(255)")
    private String password;
    @Column(name = "email", columnDefinition = "VARCHAR(255)")
    private String email;
}
