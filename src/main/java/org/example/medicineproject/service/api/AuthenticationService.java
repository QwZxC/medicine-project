package org.example.medicineproject.service.api;

import org.example.medicineproject.dto.JwtAuthenticationResponse;
import org.example.medicineproject.dto.SignInRequest;
import org.example.medicineproject.dto.SignUpRequest;

public interface AuthenticationService {

    /**
     * Регистрация пользователя
     *
     * @param request данные пользователя
     * @return токены доступа и обновления
     */
    JwtAuthenticationResponse signUp(SignUpRequest request);

    /**
     * Аутентификация пользователя
     *
     * @param request данные пользователя
     * @return токены доступа и обновления
     */
    JwtAuthenticationResponse signIn(SignInRequest request);

    /**
     * Обновление токенов доступа и обновления
     * @param refreshToken токен обновления
     * @return токены доступа и обновления
     */
    JwtAuthenticationResponse refresh(String refreshToken);
}
