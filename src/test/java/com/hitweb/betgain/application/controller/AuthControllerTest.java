package com.hitweb.betgain.application.controller;

import com.hitweb.betgain.infrastructure.services.auth.payload.request.LoginRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;  //instancie automatiquement un objet TestRestTemplate

    @Test
    public void loginTest(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("bob95");
        loginRequest.setPassword("toto3");

        String uri = "/api/auth/signin";
        HttpEntity<LoginRequest> request = new HttpEntity<>(loginRequest);
        ResponseEntity<?> responseEntity = restTemplate.postForObject(uri, request, ResponseEntity.class);
        /*assertThat(foo, notNullValue());
        assertThat(foo.getName(), is("bar"));
        ResponseEntity<?> responseEntity =  this.restTemplate.postForEntity(uri, loginRequest, ResponseEntity.class);*/

        assertNotNull(responseEntity);
    }
}
