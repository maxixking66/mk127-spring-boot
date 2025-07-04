package ir.maktabsharif127.main.service.impl;

import ir.maktabsharif127.main.domain.User;
import ir.maktabsharif127.main.dto.RegisterRequest;
import ir.maktabsharif127.main.repository.UserRepository;
import ir.maktabsharif127.main.service.UserService;
import ir.maktabsharif127.main.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final WalletService walletService;

    @Override
    @Transactional
    public User register(RegisterRequest request) {
        User user = new User();
        user.setPassword(request.getPassword());
        user.setUsername(request.getUsername());
        user.setMobileNumber(request.getMobileNumber());
        user = repository.save(user);
        walletService.createForUser(user);
        return user;
    }
}
