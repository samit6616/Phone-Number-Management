# Belong Phone Management API

## Overview

This project provides a RESTful API to manage phone numbers for a telecom operator.

It allows:

1. Viewing all phone numbers
2. Viewing phone numbers for a specific customer
3. Activating a phone number

## Technology Used

1. **Java 17**
2. **Spring Boot**
3. **Maven**
4. **Lombok**

## Setup Instructions

1. **Clone the repository:**
 `git clone https://github.com/samit6616/Phone-Number-Management.git`
2. **Navigate to the project directory**
 `cd Belong Code Test`
3. **Build the project**
 `mvn clean install`
4. **Run the application**
 `mvn spring-boot:run`

## API Endpoints

1. **Get All Phone Numbers**
 **Endpoint** : /belong/phones
 **Method** : GET
 **Response** : Returns a list of all phone numbers.

2. **Get Phone Numbers by Customer**
 **Endpoint** : /belong/phones/customer/{customerId}
 **Method** : GET
 **Response** : returns a list of phone numbers for a specific customer

3. **Activate a Phone Number**
 **Endpoint** : /belong/phones/activate?phoneNumber={phoneNumber}
 **Method** : POST
 **Response** : Activates the phone number and returns success/not found status
 **Sample CURL** : curl --location --request POST 'http://localhost:8080/belong/phones/activate?phoneNumber=9876543210' \
   --data ''

## To Run Tests

`mvn test`
