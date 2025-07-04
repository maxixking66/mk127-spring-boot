package ir.maktabsharif127.main.service.impl;

import ir.maktabsharif127.main.domain.User;
import ir.maktabsharif127.main.repository.WalletRepository;
import ir.maktabsharif127.main.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository repository;

    @Override
    public void createForUser(User user) {
        if (!repository.existsByUser_Id(user.getId())) {
            throw new RuntimeException();
//            Wallet wallet = new Wallet();
//            wallet.setUser(user);
//            repository.save(wallet);
        }
    }
}
