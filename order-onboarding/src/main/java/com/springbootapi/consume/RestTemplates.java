package com.springbootapi.consume;


import com.springbootapi.request.UserDTO;
import com.springbootapi.response.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RestTemplates implements CommandLineRunner {

    static String url = "http://localhost:8080/api/v1/users/";
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {
//        saveUser();
//        saveListOfUser();
//        getUserBYId("1");
//        getAllUser();
//        saveUserNameById();
//        updateUserById();
//        deleteUserById();

    }

    public void saveUser() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        UserDTO userDTO = UserDTO.builder()
                .email("amitesh@gmail.com")
                .name("Amitesh")
                .contact("9876789980")
                .dateOfBirth("12-09-1995")
                .build();

        HttpEntity httpEntity = new HttpEntity(userDTO, headers);

        ResponseEntity<ResponseDTO> responseEntity = restTemplate.exchange(url + "saveUser", HttpMethod.POST, httpEntity, ResponseDTO.class);
        System.out.println(responseEntity);
    }

    public void saveListOfUser() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        UserDTO userDTO1 = UserDTO.builder()
                .email("amitesh@gmail.com")
                .name("Amitesh")
                .contact("9876789980")
                .dateOfBirth("12-09-1995")
                .build();

        UserDTO userDTO2 = UserDTO.builder()
                .email("amitesh02@gmail.com")
                .name("Amitesh")
                .contact("9876789980")
                .dateOfBirth("12-09-1995")
                .build();

        UserDTO userDTO3 = UserDTO.builder()
                .email("amitesh01@gmail.com")
                .name("Amitesh")
                .contact("9876789980")
                .dateOfBirth("12-09-1995")
                .build();

        List<UserDTO> userDTOList = List.of(userDTO1, userDTO2, userDTO3);

        HttpEntity httpEntity = new HttpEntity(userDTOList, headers);

        ResponseEntity<ResponseDTO> responseEntity = restTemplate.exchange(url + "saveAllUsers", HttpMethod.POST, httpEntity, ResponseDTO.class);
        System.out.println(responseEntity);
    }

    public void getUserBYId(String id) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("id", id);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(null, headers);

        ResponseEntity<ResponseDTO> responseEntity =
                restTemplate.exchange(url + "getUser", HttpMethod.GET, httpEntity, ResponseDTO.class);
        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getHeaders());
        System.out.println(responseEntity);
    }

    public void getAllUser() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity httpEntity = new HttpEntity(null, headers);

        ResponseEntity<ResponseDTO> responseEntity =
                restTemplate.exchange(url + "getAllUsers", HttpMethod.GET, httpEntity, ResponseDTO.class);
        System.out.println(responseEntity);
    }

    public void saveUserNameById() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> pathVariables = new HashMap<>();
        pathVariables.put("id", 9);
        pathVariables.put("name", "Amitesh Kumar");

        HttpEntity httpEntity = new HttpEntity(null, headers);  //pass userDTO1 to update

        ResponseEntity<ResponseDTO> responseEntity =
                restTemplate.exchange(url + "updateUser/{id}/{name}", HttpMethod.PUT, httpEntity, ResponseDTO.class, pathVariables);
        System.out.println(responseEntity);
    }

    public void updateUserById() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> pathVariables = new HashMap<>();
        pathVariables.put("id", 9);

        UserDTO userDTO = UserDTO.builder()
                .email("amiteshRaunakKaChotaBhai@gmail.com")
                .name("Amitesh")
                .contact("9876789980")
                .dateOfBirth("12-09-1995")
                .build();

        HttpEntity httpEntity = new HttpEntity(userDTO, headers);

        ResponseEntity<ResponseDTO> responseEntity =
                restTemplate.exchange(url + "updateUser/{id}", HttpMethod.PUT, httpEntity, ResponseDTO.class, pathVariables);
        System.out.println(responseEntity);
    }

    public void deleteUserById() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url + "deleteUser").queryParam("id", "9");
        HttpEntity httpEntity = new HttpEntity(null, headers);

        ResponseEntity<ResponseDTO> responseEntity =
                restTemplate.exchange(builder.toUriString(), HttpMethod.DELETE, httpEntity, ResponseDTO.class);
        System.out.println(responseEntity);
    }

}
