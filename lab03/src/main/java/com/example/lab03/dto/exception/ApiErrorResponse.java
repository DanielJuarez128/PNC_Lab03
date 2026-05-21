package com.example.lab03.dto.exception;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse {
    private String message;
    private int status;
    private LocalDateTime timestamp;
    private String path;
}
