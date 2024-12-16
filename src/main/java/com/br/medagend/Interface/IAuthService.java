package com.br.medagend.Interface;

import com.br.medagend.request.LoginRequest;
import com.br.medagend.response.LoginResponse;

public interface IAuthService {
    LoginResponse login(LoginRequest loginRequest);
}
