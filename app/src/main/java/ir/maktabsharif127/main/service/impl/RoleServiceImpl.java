package ir.maktabsharif127.main.service.impl;

import ir.maktabsharif127.main.domain.Role;
import ir.maktabsharif127.main.repository.RoleRepository;
import ir.maktabsharif127.main.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    @Override
    public Role save(Role role) {
        return repository.save(role);
    }
}
