/*
* Copyright(C) 2023 Luvina Software Company
* StatisticRepository.java, August 21, 2023 dunghm
*/
package luvina.net.statisticservice.repository;

import luvina.net.statisticservice.model.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* Tạo interface repository để thao tác với database thông qua JpaRepository
* @author DungHM
*/
public interface StatisticRepository extends JpaRepository<Statistic, Long> {
}
