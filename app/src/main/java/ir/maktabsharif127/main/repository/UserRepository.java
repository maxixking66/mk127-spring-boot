package ir.maktabsharif127.main.repository;

import ir.maktabsharif127.main.domain.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    //    User findByUsernameAndPassword(String username, String password);
    Optional<User> findByUsernameAndPassword(String username, String password);

//    @Query(value = "select u from User u where u.username = ?1 and u.password = ?2")
//    Optional<User> findByUsernameAndPasswordCustom(String username, String password);

//    @Query(value = "select u from User u where u.username = :username and u.password = :password")
//    Optional<User> findByUsernameAndPasswordCustom(@Param("username") String username,
//                                                   @Param("password") String password);

//    @Query(value = "select u from tbl_users u where u.username = :username and u.password = :password",
//    nativeQuery = true)
//    Optional<User> findByUsernameAndPasswordCustom(@Param("username") String username,
//                                                   @Param("password") String password);

    @NativeQuery(value = "select u from tbl_users u where u.username = :username and u.password = :password")
    Optional<User> findByUsernameAndPasswordCustom(@Param("username") String username,
                                                   @Param("password") String password);

    List<User> findAllByFirstNameOrderByCreateDateDesc(String firstName);

    List<User> findAllByFirstName(String firstName, Sort sort);

}
