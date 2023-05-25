package com.example.servicetwo.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class MessageModel implements Serializable {
    @JsonProperty("serviceId")
    private Long serviceId;
    @JsonProperty("status")
    private String status;
    @JsonProperty("massage")
    private String massage;
}

