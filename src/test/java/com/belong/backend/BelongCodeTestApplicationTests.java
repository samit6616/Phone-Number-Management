package com.belong.backend;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Integration tests for the Belong Backend application.
 * These tests verify the behavior of REST endpoints.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BelongCodeTestApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(BelongCodeTestApplicationTests.class);

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Test for the endpoint that retrieves all phone numbers.
     * Verifies that the response status is 200 OK and logs the outcome.
     */
    @Test
    void testGetAllPhoneNumbers() {
        try {
            ResponseEntity<List> response = restTemplate.getForEntity("/belong/phones", List.class);
            assertEquals(200, response.getStatusCode().value());
            logger.info("Test Passed with status code {}", response.getStatusCode().value());
        } catch (Exception e) {
            logger.error("Test Failed : Error during fetching all phone numbers", e);
        }
    }

    /**
     * Test for the endpoint that retrieves phone numbers by customer ID.
     * Verifies that the response status is 200 OK and logs the outcome.
     */
    @Test
    void testGetPhoneNumbersByCustomerId() {
        int customerId = 1;
        try {
            ResponseEntity<List> response = restTemplate.getForEntity("/belong/phones/customer/" + customerId, List.class);
            assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
            logger.info("Test Passed for customer {} with status code {}", customerId, response.getStatusCode().value());
        } catch (Exception e) {
            logger.error("Test Failed: Error during fetching phone numbers for customer {}", customerId, e);
        }
    }

    /**
     * Test for the endpoint that activates a phone number.
     * Verifies that the activation is successful and logs the outcome.
     */
    @Test
    void testActivatePhoneNumber() {
        String phoneNumber = "9876543210";
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(
                    "/belong/phones/activate?phoneNumber=" + phoneNumber, null, String.class);
            assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
            logger.info("Test Passed for activating phone number {} with status code {}", phoneNumber, response.getStatusCode().value());
            logger.info("Response message: {}", response.getBody());
        } catch (Exception e) {
            logger.error("Test Failed: Error during activating phone number {}", phoneNumber, e);
        }
    }
}