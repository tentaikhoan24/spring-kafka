/*
* Copyright(C) 2023 Luvina Software Company
* AccountRepository.java, August 21, 2023 dunghm
*/
package luvina.net.accountservice.repository;

import luvina.net.accountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
* Tạo interface repository để thao tác với database thông qua JpaRepository
* @author DungHM
*/
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
