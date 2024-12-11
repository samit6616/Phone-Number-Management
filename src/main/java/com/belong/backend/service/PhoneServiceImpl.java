package com.belong.backend.service;

import com.belong.backend.model.PhoneNumber;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * This class implements methods of PhoneService interface.
 * It also loads static data while initialization
 */
@Service
public class PhoneServiceImpl implements PhoneService {
    private static final Map<Integer, List<PhoneNumber>> customerPhoneNumbers = new HashMap<>();

    static {
        customerPhoneNumbers.put(1, Arrays.asList(
                new PhoneNumber("9876543210", false),
                new PhoneNumber("99087654321", true)
        ));
        customerPhoneNumbers.put(2, Arrays.asList(
                new PhoneNumber("7890654321", false),
                new PhoneNumber("8907654321", true)
        ));
    }
    
    @Override
    public List<PhoneNumber> getAllPhoneNumbers() {
        // Returns all phone numbers across all customers
        return customerPhoneNumbers.values().stream()
                .flatMap(Collection::stream)
                .toList();
    }

    @Override
    //Returns all phone numbers for specific customer
    public List<PhoneNumber> getPhoneNumbersByCustomer(int customerId) {
        return customerPhoneNumbers.getOrDefault(customerId, Collections.emptyList());
    }

    @Override
    public boolean activatePhoneNumber(String phoneNumber) {
        //Update the phone number status to activate
        for (List<PhoneNumber> phoneNumbers : customerPhoneNumbers.values()) {
            for (PhoneNumber number : phoneNumbers) {
                if (number.getNumber().equals(phoneNumber)) {
                    number.setActive(true);
                    return true;
                }
            }
        }
        return false;
    }
}
