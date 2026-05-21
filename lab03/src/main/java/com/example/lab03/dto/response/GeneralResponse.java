package com.example.lab03.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeneralResponse {
    private String message;
    private int status;
    private Object data;
    private LocalDateTime timestamp;
    private String path;
}