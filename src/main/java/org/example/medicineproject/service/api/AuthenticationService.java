package org.example.medicineproject.service.api;

import org.example.medicineproject.dto.JwtAuthenticationResponse;
import org.example.medicineproject.dto.SignInRequest;
import org.example.medicineproject.dto.SignUpRequest;

public interface AuthenticationService {

    /**
     * Регистрация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    JwtAuthenticationResponse signUp(SignUpRequest request);

    /**
     * Аутентификация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    JwtAuthenticationResponse signIn(SignInRequest request);
}
