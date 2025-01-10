package com.springbootapi.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;


}
