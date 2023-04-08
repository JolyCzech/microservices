package com.elikhcode.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientRegistrationRequest{
        private String firstName;
        private String lastName;
        private String email;
}
