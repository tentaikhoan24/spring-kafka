/*
* Copyright(C) 2023 Luvina Software Company
* AccountserviceApplication.java, August 21, 2023 dunghm
*/
package luvina.net.accountservice;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
* Khỏi chạy chương trình
* @author DungHM
*/
@SpringBootApplication
public class AccountserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountserviceApplication.class, args);
	}

	/**
	 * Tạo topic notification trên kafka
	 * @return topic
	 */
	@Bean
	NewTopic notification() {
		// tên topic, số lượng partition, số lương bản replication tương đương với số broker
		return new NewTopic("notification", 2, (short) 1);
	}

	/**
	 * Tạo topic notification trên kafka
	 * @return topic
	 */
	@Bean
	NewTopic statistic() {
		// tên topic, số lượng partition, số lương bản replication tương đương với số broker
		return new NewTopic("statistic", 1, (short) 1);
	}

}
