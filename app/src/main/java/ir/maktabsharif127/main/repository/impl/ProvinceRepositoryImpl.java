package ir.maktabsharif127.main.repository.impl;

import ir.maktabsharif127.main.domain.Province;
import ir.maktabsharif127.main.repository.ProvinceRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

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
    public Province save(Province province) {
        province.setId(ThreadLocalRandom.current().nextLong(500, 50000));
        provinces.add(province);
        return province;
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

    @Override
    public boolean existsByName(String name) {
        return provinces.stream().anyMatch(p -> p.getName().equals(name));
    }

    @Override
    public boolean existsByNameAndIdIsNot(String name, Long id) {
        return provinces.stream().anyMatch(p -> p.getName().equals(name) && !p.getId().equals(id));
    }
}
