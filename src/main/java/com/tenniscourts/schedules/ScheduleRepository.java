package com.tenniscourts.schedules;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

	List<Schedule> findByTennisCourt_IdOrderByStartDateTime(Long id);

	@Query(value = "SELECT * FROM SCHEDULE where START_DATE_TIME >= :startDate and END_DATE_TIME <= :endDate ", nativeQuery = true)
	List<Schedule> getAllBetweenDates(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}