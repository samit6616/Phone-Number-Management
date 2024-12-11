package com.belong.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a phone number entity with its details.
 * This class is a data model used to store and retrieve phone number information.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumber {
    private String number;
    private boolean isActive;
}

