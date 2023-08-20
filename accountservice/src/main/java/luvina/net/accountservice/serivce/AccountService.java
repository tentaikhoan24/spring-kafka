/*
* Copyright(C) 2023 Luvina Software Company
* AccountService.java, August 21, 2023 dunghm
*/
package luvina.net.accountservice.serivce;

import luvina.net.accountservice.model.Account;
import luvina.net.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* Tạo service chứa các phương thức thao tác với dữ liệu và db
* @author DungHM
*/
@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    /**
     * Lưu data vào database
     * @param account dữ liệu từ client
     */
    public void save(Account account) {
        accountRepository.save(account);
    }
}
