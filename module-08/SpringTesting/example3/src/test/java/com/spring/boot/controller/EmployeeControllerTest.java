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

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private EmployeeDao employeeDao;

    @MockitoBean
    private CityDao cityDao;


    @Test
    public void shouldSaveEmployees() throws Exception {

        when(cityDao.findByName("A")).thenReturn(Optional.of(new City(1, "A")));

        mvc.perform(MockMvcRequestBuilders.put("/employees").content("{ \"name\": \"John\", \"city\": \"A\" }").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

        verify(employeeDao).save(new Employee("John", new City("A")));
    }

    @Test
    public void shouldThrowExceptionWhenCityIsNotPresent() throws Exception {
        when(cityDao.findByName("X")).thenReturn(Optional.empty());

        mvc.perform(MockMvcRequestBuilders.put("/employees").content("{ \"name\": \"John\", \"city\": \"A\" }").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());

        verify(employeeDao, never()).save(any());

    }

    @Test
    public void shhouldFetchEmployees() throws Exception {
        when(employeeDao.findAll()).thenReturn(Arrays.asList(new Employee(1,"A", new City(1, "A")), new Employee(2,"B", new City(2,"B"))));

        String res = mvc.perform(MockMvcRequestBuilders.get("/employees")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        assertThat(res).contains("{\"id\":1,\"name\":\"A\",\"city\":{\"id\":1,\"name\":\"A\"}}").contains("{\"id\":2,\"name\":\"B\",\"city\":{\"id\":2,\"name\":\"B\"}}");
    }

}