package ir.maktabsharif127.main.service.impl;

import ir.maktabsharif127.main.domain.Role;
import ir.maktabsharif127.main.repository.RoleRepository;
import ir.maktabsharif127.main.service.RoleService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    @Value("${default.roles}")
    private List<String> roles;

    @PostConstruct
    public void initDefaultData() {
        if (roles != null && !roles.isEmpty()) {
            roles.forEach(name -> {
                if (!repository.existsByName(name)) {
                    insertRole(name);
                }
            });
        }
    }

    private void insertRole(String name) {
        Role role = new Role();
        role.setName(name);
        repository.save(role);
    }

    @Override
//    @Transactional
    public Role save(Role role) {
        return repository.save(role);
    }
}
