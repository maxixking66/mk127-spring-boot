package ir.maktabsharif127.main.repository;

import ir.maktabsharif127.main.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

    boolean existsByName(String name);

}
