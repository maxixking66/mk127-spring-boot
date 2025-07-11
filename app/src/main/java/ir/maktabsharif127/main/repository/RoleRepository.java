package ir.maktabsharif127.main.repository;

import ir.maktabsharif127.main.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>, JpaSpecificationExecutor<Role> {

    boolean existsByName(String name);

    Role findByName(String name);
}
