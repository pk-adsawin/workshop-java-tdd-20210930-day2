package com.example.day02.employee;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerWebMvcTest {
   @Autowired
   private MockMvc mvc;

   @Test
   public void getById() throws Exception {
      MvcResult mvcResult = mvc.perform(get("/employee/1")).andExpect(status().isOk()).andReturn();
      ObjectMapper mapper = new ObjectMapper();
      EmployeeResponse result = mapper.readValue(mvcResult.getResponse().getContentAsByteArray(), EmployeeResponse.class);
      assertEquals(1, result.getId());
      assertEquals("adsawin", result.getName());
   }
}
