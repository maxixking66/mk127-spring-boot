package ir.maktabsharif127.main.repository;

import ir.maktabsharif127.main.domain.User;
import ir.maktabsharif127.main.dto.projection.NamesOnly;
import ir.maktabsharif127.main.dto.projection.NamesOnlyDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {


    List<NamesOnly> findAllByFirstNameContaining(String firstName);

//    List<NamesOnly> findAllByIdIsNotNull();
//    List<CredentialOnly> findAllByIdIsNotNull();

    <P> List<P> findAllByIdIsNotNull(Class<P> pClass);

    @Query(value = "select u.firstName, u.lastName from User u")
    List<NamesOnlyDTO> findAllCustom();

    @Query(value = "select new ir.maktabsharif127.main.dto.projection.NamesOnlyDTO(u.firstName, u.lastName) from User u")
    List<NamesOnlyDTO> findAllCustomV2();

}
