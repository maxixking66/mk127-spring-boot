package ir.maktabsharif127.main.repository.impl;

import ir.maktabsharif127.main.domain.City;
import ir.maktabsharif127.main.repository.CityRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CityRepositoryImpl implements CityRepository {

    private static final List<City> cities = new ArrayList<>();

    @Override
    public List<City> findAll() {
        return cities;
    }

    @Override
    public int count() {
        return cities.size();
    }

    @Override
    public void save(City city) {
        cities.add(city);
    }
}
