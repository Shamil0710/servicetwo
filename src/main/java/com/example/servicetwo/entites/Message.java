package com.example.servicetwo.entites;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long messageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private Status status;

    @Column(name = "messages")
    private String message;

    @Column(name = "time_stamp")
    private LocalDateTime timeStamp;
}
