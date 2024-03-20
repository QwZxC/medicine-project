package org.example.medicineproject.service.api;

import org.example.medicineproject.entity.user.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    /**
     * Создание пользователя
     *
     */
    void create(User user);
    /**
     * Получение пользователя по имени пользователя
     *
     * @return пользователь
     */
    User getByUsername(String username);
    /**
     * Получение пользователя по имени пользователя
     * <p>
     * Нужен для Spring Security
     *
     * @return пользователь
     */
    UserDetailsService userDetailsService();
    /**
     * Получение текущего пользователя
     *
     * @return текущий пользователь
     */
    User getCurrentUser();
}
