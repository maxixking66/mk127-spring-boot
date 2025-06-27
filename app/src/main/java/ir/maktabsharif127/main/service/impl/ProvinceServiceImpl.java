package ir.maktabsharif127.main.service.impl;

import ir.maktabsharif127.main.config.GeneralException;
import ir.maktabsharif127.main.domain.Province;
import ir.maktabsharif127.main.dto.ProvinceSaveUpdateRequest;
import ir.maktabsharif127.main.repository.ProvinceRepository;
import ir.maktabsharif127.main.service.ProvinceService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    @Override
    public Province save(ProvinceSaveUpdateRequest request) {
//        if (request.getId() == null)
        if (Objects.isNull(request.getId())) {
            return insert(request);
        } else {
            return update(request);
        }
    }


    @Override
    public Province update(Province province) {
        if (provinceRepository.existsByNameAndIdIsNot(province.getName(), province.getId())) {
            throw new GeneralException("duplicate name", HttpStatus.CONFLICT);
        }

        Province db = provinceRepository.findById(province.getId());
        db.setName(province.getName());
        return db;
//        return em.merge(db);
    }

    private Province insert(ProvinceSaveUpdateRequest request) {
        if (provinceRepository.existsByName(request.getName())) {
            throw new GeneralException("duplicate name", HttpStatus.CONFLICT);
        }
        Province province = new Province();
        province.setName(request.getName());
        return provinceRepository.save(province);
    }

    private Province update(ProvinceSaveUpdateRequest request) {
//        1      tehran
//        2      yazd
//        3      tabriz
//        input -> id: 1 , name: yazd
//        if (provinceRepository.existsByNameAndIdIsNot(request.getName(), request.getId())) {
//            throw new GeneralException("duplicate name", HttpStatus.CONFLICT);
//        }

        Province province = provinceRepository.findById(request.getId());
        if (!province.getName().equals(request.getName()) && provinceRepository.existsByName(request.getName())) {
            throw new GeneralException("duplicate name", HttpStatus.CONFLICT);
        }
        province.setName(request.getName());
        return province;
    }
}
