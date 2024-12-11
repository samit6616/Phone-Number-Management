package com.belong.backend.service;

import com.belong.backend.model.PhoneNumber;

import java.util.List;

/**
 * Service interface for managing phone numbers.
 * Provides methods to retrieve and manipulate phone number data.
 */
public interface PhoneService {

    /**
     * Retrieves a list of all phone numbers.
     */
    List<PhoneNumber> getAllPhoneNumbers();

    /**
     * Retrieves a list of all phone numbers associated with a customer.
     *
     * @param customerId the unique identifier of the customer.
     */
    List<PhoneNumber> getPhoneNumbersByCustomer(int customerId);

    /**
     * Activates a phone number.
     *
     * @param phoneNumber the phone number to be activated.
     * @return true if the activation is successful, false otherwise.
     */
    boolean activatePhoneNumber(String phoneNumber);
}
