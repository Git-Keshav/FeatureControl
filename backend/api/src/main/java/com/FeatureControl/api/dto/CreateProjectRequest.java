package com.FeatureControl.api.dto;

import jakarta.validation.constraints.NotEmpty;

public record CreateProjectRequest(@NotEmpty String name) {
}
