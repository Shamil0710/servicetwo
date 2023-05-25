package com.example.servicetwo.entites;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
@Table(name = "statuses")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "service_id", unique = true, nullable = false)
    private Long serviceId;

    @Column(name = "service_status")
    private String serviceStatus;

    @Column(name = "time_stamp")
    private LocalDateTime time_stamp;

    public static Status fromMessageModel(MessageModel messageModel) {
        return Status.builder()
                .serviceId(messageModel.getServiceId())
                .serviceStatus(messageModel.getStatus())
                .time_stamp(LocalDateTime.now())
                .build();
    }
}
