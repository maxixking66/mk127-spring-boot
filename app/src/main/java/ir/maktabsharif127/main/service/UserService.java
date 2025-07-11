package ir.maktabsharif127.main.service;

import ir.maktabsharif127.main.domain.User;
import ir.maktabsharif127.main.dto.RegisterRequest;

import java.util.Optional;

public interface UserService {
    User register(RegisterRequest request);

    Optional<User> findByUsername(String username);
}
