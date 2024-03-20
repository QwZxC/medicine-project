package org.example.medicineproject.service.api;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JwtService {

    /**
     * Генерация токена
     *
     * @param extraClaims дополнительные данные
     * @param userDetails данные пользователя
     * @return токен
     */
    String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);

    /**
     * Генерация токена
     *
     * @param userDetails данные пользователя
     * @return токен
     */
    public String generateToken(UserDetails userDetails);

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
}
