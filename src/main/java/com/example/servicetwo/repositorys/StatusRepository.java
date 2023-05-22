package com.example.servicetwo.repositorys;

import com.example.servicetwo.entites.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

    @Query("SELECT DISTINCT s.serviceId FROM Status s WHERE s.serviceStatus = 'activity'")
    List<Long> getServiceIdsWithActivityStatus();
}
