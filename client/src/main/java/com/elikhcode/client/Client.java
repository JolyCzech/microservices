package com.elikhcode.client;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
}