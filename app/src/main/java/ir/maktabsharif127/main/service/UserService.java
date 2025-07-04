package ir.maktabsharif127.main.service;

import ir.maktabsharif127.main.domain.User;
import ir.maktabsharif127.main.dto.RegisterRequest;

public interface UserService {
    User register(RegisterRequest requset);
}
