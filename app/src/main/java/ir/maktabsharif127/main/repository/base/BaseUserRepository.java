package ir.maktabsharif127.main.repository.base;

import ir.maktabsharif127.main.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BaseUserRepository<T extends User>
        extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

    Optional<T> findByUsername(String username);
}
