package com.example.day02.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class EmployeeRepositoryTest {

   @Autowired
   private EmployeeRepository employeeRepository;

   @Test
   public void case01() {
      // arrange
      Employee demo = new Employee();
      demo.setName("adsawin");
      employeeRepository.save(demo);
      // act
      Optional<Employee> result = employeeRepository.findById(1);
      // assert
      assertTrue(result.isPresent());
      assertEquals(1, result.get().getId());
      assertEquals("adsawin", result.get().getName());
   }

}
