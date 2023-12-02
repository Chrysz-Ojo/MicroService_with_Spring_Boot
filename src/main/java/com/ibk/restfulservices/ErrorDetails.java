package com.ibk.restfulservices;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}
