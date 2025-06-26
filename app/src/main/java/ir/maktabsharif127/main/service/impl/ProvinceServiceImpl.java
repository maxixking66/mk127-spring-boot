package ir.maktabsharif127.main.service.impl;

import ir.maktabsharif127.main.domain.Province;
import ir.maktabsharif127.main.repository.ProvinceRepository;
import ir.maktabsharif127.main.service.ProvinceService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProvinceServiceImpl implements ProvinceService {

    private final ProvinceRepository provinceRepository;

    @PostConstruct
    public void init() {
        if (provinceRepository.count() == 0) {
            insert(1L, "تهران");
            insert(2L, "اصفهان");
        }
    }

    private void insert(Long id, String name) {
        provinceRepository.save(
                new Province(id, name)
        );
    }

    @Override
    public Optional<Province> findByName(String name) {
        return provinceRepository.findByName(name);
    }

    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(Long id) {
        return provinceRepository.findById(id);
    }
}
