/*
* Copyright(C) 2023 Luvina Software Company
* StatisticService.java, August 21, 2023 dunghm
*/
package luvina.net.statisticservice.service;

import luvina.net.statisticservice.model.Statistic;
import luvina.net.statisticservice.repository.StatisticRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
* Nhận message từ topic và ghi vào database
* @author DungHM
*/
@Service
public class StatisticService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StatisticRepository statisticRepository;

    /**
     * Nhận message từ topic statistic và ghi vào database
     * @param statistic
     */
    @KafkaListener(id = "statisticGroup", topics = "statistic")
    public void listen(Statistic statistic) {
        logger.info("Start...save to database!!!");
        statisticRepository.save(statistic);
        logger.info("End...save to database success!!!");
    }
}
