package ir.maktabsharif127.main.service.impl;

import ir.maktabsharif127.main.domain.Role;
import ir.maktabsharif127.main.repository.RoleRepository;
import ir.maktabsharif127.main.service.RoleService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    @PostConstruct
    public void initDefaultData() {
        if (repository.count() == 0) {
            insertRole("ADMIN");
            insertRole("CUSTOMER");
        }
    }

    private void insertRole(String name) {
        Role role = new Role();
        role.setName(name);
        repository.save(role);
    }

    @Override
    public Role save(Role role) {
        return repository.save(role);
    }
}
