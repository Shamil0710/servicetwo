package com.example.servicetwo.entites;

import javax.persistence.*;

import lombok.Builder;

import java.time.LocalDateTime;

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

    public Status() {

    }

    public Status(Long id, Long serviceId, String serviceStatus, LocalDateTime time_stamp) {
        this.id = id;
        this.serviceId = serviceId;
        this.serviceStatus = serviceStatus;
        this.time_stamp = time_stamp;
    }

    public static Status fromMessageModel(MessageModel messageModel) {
        return Status.builder()
                .serviceId(messageModel.getServiceId())
                .serviceStatus(messageModel.getStatus())
                .time_stamp(LocalDateTime.now())
                .build();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public LocalDateTime getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(LocalDateTime time_stamp) {
        this.time_stamp = time_stamp;
    }
}
