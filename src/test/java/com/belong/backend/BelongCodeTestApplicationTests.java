package com.belong.backend;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BelongCodeTestApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(BelongCodeTestApplicationTests.class);

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testGetAllPhoneNumbers() {
        try {
            ResponseEntity<List> response = restTemplate.getForEntity("/belong/phones", List.class);
            assertEquals(200, response.getStatusCode().value());
            logger.info("Test Passed with status code {}", response.getStatusCode().value());
        } catch (Exception e) {
            logger.error("Test Failed : Error during fetching all phone numbers", e);
        }
    }
}