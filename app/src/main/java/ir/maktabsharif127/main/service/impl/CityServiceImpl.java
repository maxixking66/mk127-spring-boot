package ir.maktabsharif127.main.service.impl;

import ir.maktabsharif127.main.domain.City;
import ir.maktabsharif127.main.domain.Province;
import ir.maktabsharif127.main.repository.CityRepository;
import ir.maktabsharif127.main.service.CityService;
import ir.maktabsharif127.main.service.ProvinceService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    private final ProvinceService provinceService;


    @PostConstruct
    public void init() {
        if (cityRepository.count() == 0) {
            insert("تهران", provinceService.findByName("تهران"));
        }
    }

    private void insert(String name, Optional<Province> province) {
        province.ifPresent(
                value -> {
                    City city = new City(name, value);
                    cityRepository.save(city);
                    province.get().getCities().add(city);
                }
        );
    }
}
