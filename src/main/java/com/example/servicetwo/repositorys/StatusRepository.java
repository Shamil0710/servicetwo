package com.example.servicetwo.repositorys;

import com.example.servicetwo.entites.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

    @Query("SELECT DISTINCT s.serviceId FROM Status s WHERE s.serviceStatus = 'activity'")
    List<Long> getServiceIdsWithActivityStatus();
    @Modifying
    @Query("UPDATE Status s SET s.serviceStatus = ?1, s.time_stamp = ?2 where s.serviceId = ?3")
    void updateStatus(String status, LocalDateTime localDateTime, Long serviceId);
    boolean existsStatusByServiceId(Long ServiceId);
    Status getStatusesByServiceId(Long ServiceId);
}
