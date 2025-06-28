package com.spring.rest;

import com.spring.rest.ds.Customer;
import com.spring.rest.ds.Customers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerApiControllerTest {

    private static final Customer CUSTOMER_1 = new Customer(1, "CC", "Caitlin", "Chen");
    private static final Customer CUSTOMER_2 = new Customer(2, "KT", "Kamila", "Terry");
    private static final Customer CUSTOMER_3 = new Customer(3, "EH", "Eve", "Harrell");
    private static final Customer CUSTOMER_4 = new Customer(null, "JD", "John", "Doe");
    private static final Customer CUSTOMER_5 = new Customer(null, "AH", "Adalyn", "Hooper");
    private static final Customer CUSTOMER_6 = new Customer(null, "CF", "Chase", "Freeman");


    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldListAllCustomers() {
        Customers customers = testRestTemplate.getForObject("/customers", Customers.class);
        assertThat(customers.getCustomers()).containsExactly(CUSTOMER_1, CUSTOMER_2, CUSTOMER_3);
    }

    @Test
    public void shouldListCustomersAsEntity() {
        ResponseEntity<Customers> customersResponseEntity = testRestTemplate.getForEntity("/customers", Customers.class);
        assertEquals(customersResponseEntity.getStatusCode(), HttpStatus.OK);
        assertThat(customersResponseEntity.getBody().getCustomers()).containsExactly(CUSTOMER_1, CUSTOMER_2, CUSTOMER_3);
    }


}
