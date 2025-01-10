package com.springbootapi.consume;

import com.springbootapi.request.UserDTO;
import com.springbootapi.response.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;


@Component
public class RestClients implements CommandLineRunner {

    static String url = "http://localhost:8080/api/v1/users/";

    @Value("${user.value}")
    private String value;

    @Value("${user.id}")
    private int id;

    @Value("${user.name}")
    private String name;
    @Autowired
    private RestClient restClient;

    @Override
    public void run(String... args) throws Exception {

//        saveUser();
//        saveAllUser();
//        updateUserNameById(id,name);
//        updateUserById();
//        getUserById(value);
//        deleteUserById(value);
//        getAllUser();

    }

    public void saveUser() {
        UserDTO userDTO = UserDTO.builder().name("Amitesh")
                .dateOfBirth("08-08-1997").contact("8759632145").email("amitesh11121@gmail.com").build();
        ResponseEntity<String> result = restClient.post()
                .uri(url + "saveUser")
                .contentType(MediaType.APPLICATION_JSON)
                .body(userDTO)
                .retrieve()
                .toEntity(String.class);
        System.out.println(result.getBody());
    }

    public void saveAllUser() {
        UserDTO userDTO1 = UserDTO.builder().name("Raunak")
                .dateOfBirth("08-08-1995").contact("8746985112").email("raunak@gmail.com").build();
        UserDTO userDTO2 = UserDTO.builder().name("Monu")
                .dateOfBirth("08-08-1996").contact("7965238455").email("monu@gmail.com").build();
        ResponseEntity<String> result = restClient.post()
                .uri(url + "saveAllUsers")
                .contentType(MediaType.APPLICATION_JSON)
                .body(List.of(userDTO1, userDTO2))
                .retrieve()
                .toEntity(String.class);
        System.out.println(result.getBody());
    }

    public void getAllUser() {
        ResponseEntity<ResponseDTO> result = restClient.get()
                .uri(url + "getAllUsers")
                .retrieve()
                .toEntity(ResponseDTO.class);
        System.out.println(result.getBody());
    }

    public void getUserById(String value) {
        ResponseEntity<ResponseDTO> result = restClient.get()
                .uri(url + "getUser")
                .header("id", value)
                .retrieve()
                .toEntity(ResponseDTO.class);
        System.out.println(result.getBody());
    }

    public void updateUserById() {
        UserDTO userDTO = UserDTO.builder().name("Amitesh Kumar Mehta")
                .dateOfBirth("08-08-1997").contact("8759632145").email("amitesh111@gmail.com").build();
        int id = 1;
        ResponseEntity<String> result = restClient.put()
                .uri(url + "updateUser" + "/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .body(userDTO)
                .retrieve()
                .toEntity(String.class);
        System.out.println(result.getBody());
    }

    public void updateUserNameById(int id,String name) {
        ResponseEntity<String> result = restClient.put()
                .uri(url + "updateUser" + "/{id}/{name}", id, name)
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(String.class);
        System.out.println(result.getBody());
    }

    public void deleteUserById(String id) {
        ResponseEntity<String> result = restClient.delete()
                .uri(url + "deleteUser", uriBuilder -> uriBuilder
                        .queryParam("id", id)
                        .build())
                .retrieve()
                .toEntity(String.class);
        System.out.println(result.getBody());
    }

}
