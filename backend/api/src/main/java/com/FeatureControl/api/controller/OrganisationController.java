package com.FeatureControl.api.controller;

import com.FeatureControl.api.dto.CreateOrganisationRequest;
import com.FeatureControl.api.model.Organisation;
import com.FeatureControl.api.service.OrganisationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orgs")
public class OrganisationController {
    private final OrganisationService organisationService;

    public OrganisationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Organisation create(@Valid @RequestBody CreateOrganisationRequest request) {
        System.out.println("Organisation created");
        return organisationService.create(request.name());
    }

    @GetMapping
    public List<Organisation> getAll() {
        System.out.println("Getting all organisations...");
        return organisationService.getAll();
    }

    @GetMapping("/orgs/{orgID}")
    public Organisation getById(@PathVariable UUID orgID) {
        System.out.println("Getting organisation by ID...");
        return organisationService.getById(orgID);
    }
}
