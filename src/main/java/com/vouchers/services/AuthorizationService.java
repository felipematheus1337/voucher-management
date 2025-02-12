package com.vouchers.services;

import com.vouchers.dtos.CreateUserDTO;
import com.vouchers.models.Role;
import com.vouchers.models.User;
import com.vouchers.repositories.RoleRepository;
import com.vouchers.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Set;

@Service
public class AuthorizationService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthorizationService(RoleRepository repository, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.roleRepository = repository;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void createUser(CreateUserDTO dto) {

        var basicRole = roleRepository.findByName(Role.Values.BASIC.name());

        var userFromDB = userRepository.findByUserName(dto.username());

        if (userFromDB.isPresent())
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);

        var user = new User();
        user.setUsername(dto.username());
        user.setPassword(bCryptPasswordEncoder.encode(dto.password()));
        user.setRoles(Set.of(basicRole.get()));

        userRepository.save(user);
    }

    public List<User> listUsers() {

        return userRepository.findAll();
    }
}
