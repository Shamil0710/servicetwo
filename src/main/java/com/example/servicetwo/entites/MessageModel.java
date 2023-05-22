package com.example.servicetwo.entites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class MessageModel implements Serializable {
    @JsonProperty("serviceId")
    private int serviceId;
    @JsonProperty("status")
    private String status;
}

