package com.FeatureControl.api.dto;

import jakarta.validation.constraints.NotEmpty;

public record CreateOrganisationRequest(@NotEmpty String name){

}
