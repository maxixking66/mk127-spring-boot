package ir.maktabsharif127.main.service;

import ir.maktabsharif127.main.domain.Province;

import java.util.Optional;

public interface ProvinceService {
    Optional<Province> findByName(String name);
}
