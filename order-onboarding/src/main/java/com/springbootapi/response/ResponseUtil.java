package com.springbootapi.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Collections;
public class ResponseUtil {

    private static ResponseEntity<ResponseDTO> createResponse(HttpStatus status, String code, String description, Object data) {
        Meta meta = Meta.builder().code(code).description(description).build();
        ResponseDTO responseDTO = ResponseDTO.builder().meta(meta).data(data).build();
        return ResponseEntity.status(status).body(responseDTO);

    }

    public static ResponseEntity<ResponseDTO> success(String description, Object data) {
        return createResponse(HttpStatus.OK, "200 OK", description, data);
    }

    public static ResponseEntity<ResponseDTO> created(String description, Object data) {
        return createResponse(HttpStatus.CREATED, "201 Created", description, data);
    }

    public static ResponseEntity<ResponseDTO> notFound(String description) {
        return createResponse(HttpStatus.NOT_FOUND, "404 Not Found", description, null);
    }

    public static ResponseEntity<ResponseDTO> failed(String errors) {
        return createResponse(HttpStatus.BAD_REQUEST, "400", errors, null);
    }


}
