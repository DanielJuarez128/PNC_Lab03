package com.example.lab03.controller;

import com.example.lab03.dto.request.CreateSpecimenRequest;
import com.example.lab03.dto.request.UpdateSpecimenRequest;
import com.example.lab03.dto.response.GeneralResponse;
import com.example.lab03.dto.response.PageableResponse;
import com.example.lab03.dto.response.SpecimenResponse;
import com.example.lab03.service.impl.SpecimenServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/api/specimen")
@AllArgsConstructor
public class SpecimenController {
    private SpecimenServiceImpl specimenService;

    // ✅ Método reutilizable para respuestas estándar
    private ResponseEntity<GeneralResponse> buildResponse(
            String message,
            HttpStatus status,
            Object data,
            HttpServletRequest request
    ) {

        GeneralResponse response = GeneralResponse.builder()
                .message(message)
                .status(status.value())
                .data(data)
                .timestamp(LocalDateTime.now())
                .path(request.getRequestURI())
                .build();

        return new ResponseEntity<>(response, status);
    }

    // ✅ CREATE
    @PostMapping
    public ResponseEntity<GeneralResponse> createSpecimen(
            @RequestBody CreateSpecimenRequest request,
            HttpServletRequest httpRequest
    ) {
        SpecimenResponse response = specimenService.createSpecimen(request);
        return buildResponse("Specimen created successfully", HttpStatus.CREATED, response, httpRequest);
    }

    // ✅ READ ALL con PAGINACIÓN ✅
    @GetMapping
    public ResponseEntity<GeneralResponse> getAllSpecimens(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder,
            HttpServletRequest request
    ) {
        PageableResponse<?> response = specimenService.getAllSpecimens(page, size, sortBy, sortOrder);
        return buildResponse("Specimens retrieved successfully", HttpStatus.OK, response, request);
    }

    // ✅ READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<GeneralResponse> getSpecimenById(
            @PathVariable UUID id,
            HttpServletRequest request
    ) {
        SpecimenResponse response = specimenService.getSpecimenById(id);
        return buildResponse("Specimen found", HttpStatus.OK, response, request);
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<GeneralResponse> updateSpecimen(
            @PathVariable UUID id,
            @RequestBody UpdateSpecimenRequest requestBody,
            HttpServletRequest request
    ) {
        SpecimenResponse response = specimenService.updateSpecimen(id, requestBody);
        return buildResponse("Specimen updated successfully", HttpStatus.OK, response, request);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<GeneralResponse> deleteSpecimen(
            @PathVariable UUID id,
            HttpServletRequest request
    ) {
        SpecimenResponse response = specimenService.deleteSpecimen(id);
        return buildResponse("Specimen deleted successfully", HttpStatus.OK, response, request);
    }
}
