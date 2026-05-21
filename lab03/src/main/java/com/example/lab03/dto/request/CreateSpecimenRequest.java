package com.example.lab03.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSpecimenRequest {
    @NotBlank(message = "The specimen name cannot be empty.")
    private String name;

    @NotBlank(message = "The region of Hyrule must be specified.")
    private String region;

    @NotNull(message = "Danger level is required.")
    private Integer dangerLevel;

    @NotNull(message = "You must specify if the specimen is friendly.")
    private Boolean isFriendly;
}