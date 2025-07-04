package ir.maktabsharif127.main.repository.base;

import ir.maktabsharif127.main.domain.base.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

@NoRepositoryBean
public interface BaseEntityRepository<T extends BaseEntity<ID>, ID extends Serializable>
        extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    List<T> findAllByCreateDateIsBetween(ZonedDateTime start, ZonedDateTime end);
}
