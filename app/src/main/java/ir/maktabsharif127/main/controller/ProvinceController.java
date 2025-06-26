package ir.maktabsharif127.main.controller;

import ir.maktabsharif127.main.dto.CityDTO;
import ir.maktabsharif127.main.dto.ProvinceWithCityDTO;
import ir.maktabsharif127.main.dto.ProvinceWithoutCityDTO;
import ir.maktabsharif127.main.mapper.ProvinceMapper;
import ir.maktabsharif127.main.service.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/provinces")
@RequiredArgsConstructor
public class ProvinceController {

    private final ProvinceService provinceService;

    private final ProvinceMapper mapper;

    @GetMapping("/with-cities")
    public ResponseEntity<List<ProvinceWithCityDTO>> findAllWithCities() {
        return ResponseEntity.ok(
                mapper.convertToWithCity(
                        provinceService.findAll()
                )
        );
    }

    @GetMapping("/without-cities")
    public ResponseEntity<List<ProvinceWithoutCityDTO>> findAllWithoutCities() {
        return ResponseEntity.ok(
                mapper.convertToWithoutCity(
                        provinceService.findAll()
                )
        );
    }

    @GetMapping("/{provinceId}/cities")
    public ResponseEntity<List<CityDTO>> findAllCitiesByProvinceId(@PathVariable Long provinceId) {
        return ResponseEntity.ok(
                mapper.convertToCityDTOs(
                        provinceService.findById(provinceId)
                                .getCities()
                )
        );
    }
}
