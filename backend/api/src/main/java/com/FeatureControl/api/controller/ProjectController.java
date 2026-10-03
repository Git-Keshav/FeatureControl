package com.FeatureControl.api.controller;

import com.FeatureControl.api.dto.CreateProjectRequest;
import com.FeatureControl.api.model.Project;
import com.FeatureControl.api.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/orgs/{orgId}/projects")
    @ResponseStatus(HttpStatus.CREATED)
    public Project create(@PathVariable UUID orgId, @Valid @RequestBody CreateProjectRequest request){
        return projectService.create(orgId, request.name());
    }

    @GetMapping("/orgs/{orgId}/projects")
    public List<Project> getAllForOrganisation(@PathVariable UUID orgId){
        return projectService.getAllForOrganisation(orgId);
    }

    @GetMapping("/projects/{projectId}")
    public Project getById(@PathVariable UUID projectId) {
        return projectService.getById(projectId);
    }
}
