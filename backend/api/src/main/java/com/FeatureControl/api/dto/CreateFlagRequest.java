package com.FeatureControl.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record CreateFlagRequest (
    @NotEmpty
    @Pattern(regexp = "[a-z0-9-]+", message = "use only lower case, number and hyphens")
    String key,
    @NotBlank String name
){}
