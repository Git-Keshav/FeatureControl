package com.FeatureControl.api.dto;

import jakarta.validation.constraints.NotNull;

public record UpdateFlagStateRequest(@NotNull Boolean enabled) {}
