package com.belong.backend.service;

import com.belong.backend.model.PhoneNumber;

import java.util.List;

public interface PhoneService {

    List<PhoneNumber> getAllPhoneNumbers();

    List<PhoneNumber> getPhoneNumbersByCustomer(int customerId);

    boolean activatePhoneNumber(String phoneNumber);
}
