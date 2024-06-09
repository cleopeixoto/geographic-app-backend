package com.java.geographic.models;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.index.Indexed;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class Network {
    @Id
    @GeneratedValue
    private String _id;

    @Id
    private String subStationId;

    @Indexed(unique = true)
    private String code;

    private String name;
    private Integer tension;
    private LocalDateTime created;
}
