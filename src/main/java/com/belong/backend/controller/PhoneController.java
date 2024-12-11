package com.belong.backend.controller;

import com.belong.backend.model.PhoneNumber;
import com.belong.backend.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing phone numbers.
 * Provides endpoints to retrieve and activate phone numbers.
 */
@RestController
@RequestMapping("/belong/phones")
public class PhoneController {

    private final PhoneService phoneService;

    @Autowired
    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping
    public List<PhoneNumber> getAllPhoneNumbers() {
        return phoneService.getAllPhoneNumbers();
    }

    @GetMapping("/customer/{customerId}")
    public List<PhoneNumber> getAllPhoneNumbersByCustomerId(@PathVariable int customerId) {
        return phoneService.getPhoneNumbersByCustomer(customerId);
    }

    @PostMapping("/activate")
    public String activateCustomerPhoneNumber(@RequestParam String phoneNumber) {
        boolean activated = phoneService.activatePhoneNumber(phoneNumber);
        if (activated) {
            return "Phone Number " + phoneNumber + " Activated Successfully.";
        } else {
            return "Phone Number " + phoneNumber + " Not Found.";
        }
    }
}
