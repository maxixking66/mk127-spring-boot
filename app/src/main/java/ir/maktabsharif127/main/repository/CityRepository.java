package ir.maktabsharif127.main.repository;

import ir.maktabsharif127.main.domain.City;

import java.util.List;

public interface CityRepository {

    List<City> findAll();

    int count();

    void save(City city);
}
