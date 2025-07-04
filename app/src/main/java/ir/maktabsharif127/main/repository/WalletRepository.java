package ir.maktabsharif127.main.repository;

import ir.maktabsharif127.main.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    boolean existsByUser_Id(Long id);
}
