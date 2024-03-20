package org.example.medicineproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.medicineproject.entity.user.User;
import org.example.medicineproject.excpetion.AlreadyExistsException;
import org.example.medicineproject.repository.UserRepository;
import org.example.medicineproject.service.api.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public void create(User user) {
        if (repository.existsByUsername(user.getUsername())) {
            throw new AlreadyExistsException("Пользователь с таким именем уже существует");
        }

        if (repository.existsByEmail(user.getEmail())) {
            throw new AlreadyExistsException("Пользователь с таким email уже существует");
        }

        repository.save(user);
    }

    @Override
    public User getByUsername(String username) {
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
    }

    @Override
    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    @Override
    public User getCurrentUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }
}
