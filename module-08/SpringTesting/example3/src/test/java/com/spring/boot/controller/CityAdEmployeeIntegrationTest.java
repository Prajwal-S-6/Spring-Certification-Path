package com.spring.boot.controller;

import com.spring.boot.dao.CityDao;
import com.spring.boot.dao.EmployeeDao;
import com.spring.boot.entity.City;
import com.spring.boot.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {CityController.class, EmployeeController.class})
public class CityAdEmployeeIntegrationTest {

    @MockitoBean
    private EmployeeDao employeeDao;

    @MockitoBean
    private CityDao cityDao;

    @Autowired
    private MockMvc mvc;


    @Test
    public void shouldSaveCityAndShouldSaveEmployee() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/cities").content("{ \"name\": \"A\" }").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        verify(cityDao).save(new City("A"));

        when(cityDao.findByName("A")).thenReturn(Optional.of(new City(1, "A")));

        mvc.perform(MockMvcRequestBuilders.put("/employees").contentType(MediaType.APPLICATION_JSON).content("{ \"name\": \"A\", \"city\": \"A\" }")).andExpect(status().isOk());

        verify(employeeDao).save(new Employee("A", new City("A")));
    }


}
