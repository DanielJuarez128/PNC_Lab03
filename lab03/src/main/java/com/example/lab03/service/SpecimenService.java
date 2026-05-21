package com.example.lab03.service;

import com.example.lab03.dto.request.CreateSpecimenRequest;
import com.example.lab03.dto.request.UpdateSpecimenRequest;
import com.example.lab03.dto.response.PageableResponse;
import com.example.lab03.dto.response.SpecimenResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface SpecimenService {
    @Transactional
    SpecimenResponse createSpecimen(CreateSpecimenRequest request);

    PageableResponse getAllSpecimens(int page, int size, String sortBy, String sortOrder);

    SpecimenResponse getSpecimenById(UUID id);

    @Transactional
    SpecimenResponse updateSpecimen(UUID id, UpdateSpecimenRequest request);

    @Transactional
    SpecimenResponse deleteSpecimen(UUID id);
}
