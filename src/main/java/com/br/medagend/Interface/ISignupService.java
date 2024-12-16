package com.br.medagend.Interface;

import com.br.medagend.request.SignupRequest;
import com.br.medagend.response.SignupResponse;

public interface ISignupService {
    SignupResponse signup(SignupRequest signupRequest);
}
