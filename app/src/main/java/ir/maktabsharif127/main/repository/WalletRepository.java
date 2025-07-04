package ir.maktabsharif127.main.repository;

import ir.maktabsharif127.main.domain.Wallet;
import ir.maktabsharif127.main.repository.base.BaseEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends BaseEntityRepository<Wallet, Long> {

    boolean existsByUser_Id(Long id);
}
