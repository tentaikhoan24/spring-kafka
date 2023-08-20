/*
* Copyright(C) 2023 Luvina Software Company
* NotificationserviceApplication.java, August 21, 2023 dunghm
*/
package luvina.net.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;

/**
* khởi chạy chương trình
* @author DungHM
*/

@SpringBootApplication
@EnableAsync
public class NotificationserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(NotificationserviceApplication.class, args);
	}

	/**
	 * Conver message từ topic sang Json
	 * @return Json message
	 */
	@Bean
	JsonMessageConverter converter() {
		return new JsonMessageConverter();
	}
}
