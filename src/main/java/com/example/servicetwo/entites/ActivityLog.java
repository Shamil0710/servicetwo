package com.example.servicetwo.entites;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "activitylogs", schema = "neeastestdb")
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Long logId;
    
    @Column(name = "activity")
    private String activity;

    @Column(name = "time_stamp")
    private LocalDateTime timeStamp;
}
