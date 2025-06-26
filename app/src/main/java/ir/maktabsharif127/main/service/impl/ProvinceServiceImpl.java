package ir.maktabsharif127.main.service.impl;

import ir.maktabsharif127.main.domain.Province;
import ir.maktabsharif127.main.repository.ProvinceRepository;
import ir.maktabsharif127.main.service.ProvinceService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProvinceServiceImpl implements ProvinceService {

    private final ProvinceRepository provinceRepository;

    @PostConstruct
    public void init() {
        if (provinceRepository.count() == 0) {
            insert("تهران");
            insert("اصفهان");
        }
    }

    private void insert(String name) {
        provinceRepository.save(
                new Province(name)
        );
    }

    @Override
    public Optional<Province> findByName(String name) {
        return provinceRepository.findByName(name);
    }
}
