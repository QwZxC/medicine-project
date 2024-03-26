package org.example.medicineproject.service.api;

import org.example.medicineproject.dto.JwtAuthenticationResponse;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.Map;

public interface JwtService {

    /**
     * Генерация токена
     *
     * @param extraClaims дополнительные данные
     * @param userDetails данные пользователя
     * @param expiration дата истечения
     * @return токен
     */
    String generateToken(Map<String, Object> extraClaims, UserDetails userDetails, Date expiration);

    /**
     * Генерация токена
     *
     * @param userDetails данные пользователя
     * @return токен доступа
     */
    String generateAccessToken(UserDetails userDetails);

    /**
     * Генерация токена обновления
     * @param userDetails данные пользователя
     * @return токен обновления
     */
    String generateRefreshToken(UserDetails userDetails);

    /**
     * Проверка токена на валидность
     *
     * @param token       токен
     * @param userDetails данные пользователя
     * @return true, если токен валиден
     */
    boolean isTokenValid(String token, UserDetails userDetails);

    /**
     * Извлечение имени пользователя из токена
     *
     * @param token токен
     * @return имя пользователя
     */
    String extractUserName(String token);

    /**
     * Обновление токена доступа и токена обновления
     *
     * @param refreshToken токен доступа
     * @return токены доступа и обновления
     */
    JwtAuthenticationResponse refreshUserTokens(String refreshToken);
}
