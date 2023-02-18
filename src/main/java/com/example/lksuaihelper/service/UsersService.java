package com.example.lksuaihelper.service;

import com.example.lksuaihelper.model.Role;
import com.example.lksuaihelper.model.User;
import com.example.lksuaihelper.repository.UsersRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements UserDetailsService {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = usersRepository.findByUsername(username);

        User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("Пользователь с таким именем не найден"));

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), null);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public User findUserById(Long userId) throws UsernameNotFoundException {
        Optional<User> userOptional = usersRepository.findById(userId);

        return userOptional.orElseThrow(() -> new UsernameNotFoundException("Пользователь с таким id не найден"));
    }

    public List<User> allUsers() {
        return usersRepository.findAll();
    }

    public boolean saveUser(User user) {
        Optional<User> userOptional = usersRepository.findByUsername(user.getName());

        if (userOptional.isEmpty()) {
            return false;
        }

        user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
        return true;
    }

    public boolean deleteUser(Long userId) {
        if (usersRepository.findById(userId).isPresent()) {
            usersRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
