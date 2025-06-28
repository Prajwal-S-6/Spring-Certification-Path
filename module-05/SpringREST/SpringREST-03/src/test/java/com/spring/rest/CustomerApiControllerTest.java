package com.spring.rest;

import com.spring.rest.ds.Customer;
import com.spring.rest.ds.CustomerCriteria;
import com.spring.rest.ds.Customers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;

import java.net.URI;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpStatus.*;

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
        assertEquals(OK, customersResponseEntity.getStatusCode());
        assertThat(customersResponseEntity.getBody().getCustomers()).containsExactly(CUSTOMER_1, CUSTOMER_2, CUSTOMER_3);
    }

    @Test
    public void shouldGetCustomerAsObject() {
        Customer customer = testRestTemplate.getForObject("/customers/{id}", Customer.class, 1);
        assertEquals(CUSTOMER_1,customer);
    }

    @Test
    public void shouldGetCustomerCountInHeader() {
        HttpHeaders httpHeaders = testRestTemplate.headForHeaders("/customers");
        assertTrue(httpHeaders.containsKey("Customers-Count"));
        assertEquals("3", httpHeaders.getFirst("Customers-Count"));
    }

    @Test
    public void shouldCreateCustomerAndReturnLocation() {
        URI uri = testRestTemplate.postForLocation("/customers", CUSTOMER_4);

        assertEquals(URI.create("/customers/4"), uri);
    }

    @Test
    public void shouldCreateCustomerAndReturnEntity() {
        ResponseEntity<Customer> customerResponseEntity = testRestTemplate.postForEntity("/customers", CUSTOMER_4, Customer.class);
        assertEquals(HttpStatus.CREATED, customerResponseEntity.getStatusCode());
        assertEquals(URI.create("/customers/4"), customerResponseEntity.getHeaders().getLocation());
        assertEquals(new Customer(4, CUSTOMER_4.getCode(), CUSTOMER_4.getFirstName(), CUSTOMER_4.getLastName()), customerResponseEntity.getBody());
    }

    @Test
    public void shouldCreateCustomerAndReturnObject() {
        Customer customer = testRestTemplate.postForObject("/customers", CUSTOMER_5, Customer.class);
        assertEquals(new Customer(4, CUSTOMER_5.getCode(), CUSTOMER_5.getFirstName(), CUSTOMER_5.getLastName()), customer);
    }

    @Test
    public void shouldBulkUpdateCustomers() {
        testRestTemplate.put("/customers", Arrays.asList(CUSTOMER_4, CUSTOMER_5, CUSTOMER_6));
        Customers customers = testRestTemplate.getForObject("/customers", Customers.class);

        assertThat(customers.getCustomers()).containsExactly(
                new Customer(4, CUSTOMER_4.getCode(), CUSTOMER_4.getFirstName(), CUSTOMER_4.getLastName()),
                new Customer(5, CUSTOMER_5.getCode(), CUSTOMER_5.getFirstName(), CUSTOMER_5.getLastName()),
                new Customer(6, CUSTOMER_6.getCode(), CUSTOMER_6.getFirstName(), CUSTOMER_6.getLastName())
        );
    }

    @Test
    public void shouldUpdateACustomer() {
        testRestTemplate.put("/customers/{id}", CUSTOMER_6, 1);
        Customer customer = testRestTemplate.getForObject("/customers/1", Customer.class);

        assertEquals(new Customer(1, CUSTOMER_6.getCode(), CUSTOMER_6.getFirstName(), CUSTOMER_6.getLastName()), customer);
    }

    @Test
    public void shouldDeleteCustomer() {
//        testRestTemplate.delete("/customers/{id}", 1);

        HttpStatusCode code =  testRestTemplate.execute("/customers/1", HttpMethod.DELETE, null, ClientHttpResponse::getStatusCode);
        Customers customers = testRestTemplate.getForObject("/customers", Customers.class);

        assertEquals(NO_CONTENT, code);
        assertThat(customers.getCustomers()).containsExactly(CUSTOMER_2, CUSTOMER_3);
    }

    @Test
    public void shouldDeleteAllCustomers() {
        testRestTemplate.delete("/customers");
        Customers customers = testRestTemplate.getForObject("/customers", Customers.class);

        assertThat(customers.getCustomers()).isEmpty();
    }

    @Test
    public void shouldReturnNotFoundOnSecondDelete() {
        testRestTemplate.delete("/customers");

        HttpStatusCode httpStatus = testRestTemplate.execute("/customers", HttpMethod.DELETE, null, ClientHttpResponse::getStatusCode);

        assertEquals(NOT_FOUND, httpStatus);
    }

    @Test
    public void shouldFindCustomerWithFirstNameLike() {
        CustomerCriteria customerCriteria = new CustomerCriteria("Ca%");

        ResponseEntity<Customers> customers = testRestTemplate.postForEntity("/customers/search", customerCriteria, Customers.class);

        assertEquals(OK, customers.getStatusCode());
        assertThat(customers.getBody().getCustomers()).containsExactly(CUSTOMER_1);
    }

    @Test
    public void shouldReturnNotFound() {
        CustomerCriteria customerCriteria = new CustomerCriteria("%xyz%");
        ResponseEntity<Customers> customers = testRestTemplate.postForEntity("/customers/search", customerCriteria, Customers.class);

        assertEquals(NOT_FOUND, customers.getStatusCode());
        assertNull(customers.getBody());
    }

    @Test
    public void shouldGetAllowedHttpMethods() {
        Set<HttpMethod> httpMethodSet = testRestTemplate.optionsForAllow("/options");

        assertThat(httpMethodSet).containsExactlyInAnyOrder(HttpMethod.GET, HttpMethod.DELETE, HttpMethod.POST, HttpMethod.PUT);
    }
}
