package com.example.servicetwo.entites;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
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
}
