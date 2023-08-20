package luvina.net.statisticservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.converter.JsonMessageConverter;

@SpringBootApplication
public class StatisticserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StatisticserviceApplication.class, args);
	}

	/**
	 * Convert message từ topic sang Json
	 * @return Json: message
	 */
	@Bean
	JsonMessageConverter converter() {
		return new JsonMessageConverter();
	}
}
