package com.sonukumar.services.authentication;

import com.sonukumar.dto.RegisterRequest;
import com.sonukumar.dto.UserDto;

public interface AuthenticationService {

    UserDto createCustomer(RegisterRequest registerRequest);
    boolean hasCustomerWithEmail(String email);

}
