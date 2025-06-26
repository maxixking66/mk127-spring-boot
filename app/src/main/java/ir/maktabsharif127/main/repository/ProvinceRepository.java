package ir.maktabsharif127.main.repository;

import ir.maktabsharif127.main.domain.Province;

import java.util.List;
import java.util.Optional;

public interface ProvinceRepository {

    List<Province> findAll();

    long count();

    void save(Province province);

    Optional<Province> findByName(String name);

    Province findById(Long id);
}
