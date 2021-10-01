package com.example.day02.employee;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

   @Autowired
   private TestRestTemplate restTemplate;

   @Test
   void testGetById() {
      EmployeeResponse result = restTemplate.getForObject("/employee/1", EmployeeResponse.class);
      assertEquals(1, result.getId());
      assertEquals("adsawin", result.getName());
   }

}
