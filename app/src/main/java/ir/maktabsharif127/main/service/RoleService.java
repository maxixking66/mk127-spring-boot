package ir.maktabsharif127.main.service;

import ir.maktabsharif127.main.domain.Role;

public interface RoleService {
    Role save(Role role);

    Role findByName(String name);
}
