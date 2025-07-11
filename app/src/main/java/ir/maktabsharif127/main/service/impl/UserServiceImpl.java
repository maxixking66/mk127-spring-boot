package ir.maktabsharif127.main.service.impl;

import ir.maktabsharif127.main.domain.User;
import ir.maktabsharif127.main.dto.RegisterRequest;
import ir.maktabsharif127.main.repository.UserRepository;
import ir.maktabsharif127.main.service.RoleService;
import ir.maktabsharif127.main.service.UserService;
import ir.maktabsharif127.main.service.WalletService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final WalletService walletService;

    private final RoleService roleService;

    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        if (repository.count() == 0) {
            User defaultUser = new User();
            defaultUser.setFirstName("mohsen");
            defaultUser.setLastName("asgari");
            defaultUser.setUsername("asgari");
            defaultUser.setPassword(passwordEncoder.encode("asgari"));
            defaultUser.setRoles(
                    Set.of(
                            roleService.findByName("ADMIN")
                    )
            );
            repository.save(defaultUser);
        }
    }

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

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
