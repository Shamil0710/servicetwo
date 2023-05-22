package com.example.servicetwo.repositorys;

import com.example.servicetwo.entites.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findMessageByServiceId_ServiceId(Long id);
}
