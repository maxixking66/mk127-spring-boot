package ir.maktabsharif127.main.repository.impl;

import ir.maktabsharif127.main.domain.Province;
import ir.maktabsharif127.main.repository.ProvinceRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProvinceRepositoryImpl implements ProvinceRepository {

    private static final List<Province> provinces = new ArrayList<>();

    @Override
    public List<Province> findAll() {
        return provinces;
    }

    @Override
    public long count() {
        return provinces.size();
    }

    @Override
    public void save(Province province) {
        provinces.add(province);
    }

    @Override
    public Optional<Province> findByName(String name) {
        return provinces.stream().filter(p -> p.getName().equals(name))
                .findAny();
    }

    @Override
    public Province findById(Long id) {
        return provinces.stream().filter(p -> p.getId().equals(id))
                .findAny().orElseThrow(
                        () -> new RuntimeException("not found")
                );
    }
}
