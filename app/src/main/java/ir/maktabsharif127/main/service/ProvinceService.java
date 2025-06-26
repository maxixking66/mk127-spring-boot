package ir.maktabsharif127.main.service;

import ir.maktabsharif127.main.domain.Province;

import java.util.List;
import java.util.Optional;

public interface ProvinceService {
    Optional<Province> findByName(String name);

    List<Province> findAll();

    Province findById(Long id);
}
