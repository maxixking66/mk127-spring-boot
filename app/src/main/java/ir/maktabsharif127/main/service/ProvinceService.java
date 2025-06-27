package ir.maktabsharif127.main.service;

import ir.maktabsharif127.main.domain.Province;
import ir.maktabsharif127.main.dto.ProvinceSaveUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface ProvinceService {
    Optional<Province> findByName(String name);

    List<Province> findAll();

    Province findById(Long id);

    Province save(ProvinceSaveUpdateRequest request);

    Province update(Province province);
}
