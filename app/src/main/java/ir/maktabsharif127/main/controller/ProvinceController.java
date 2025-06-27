package ir.maktabsharif127.main.controller;

import ir.maktabsharif127.main.dto.*;
import ir.maktabsharif127.main.mapper.ProvinceMapper;
import ir.maktabsharif127.main.service.ProvinceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<ProvinceWithoutCityDTO> create(
            @RequestBody @Validated(value = ValidationGroup.Save.class) ProvinceSaveUpdateRequest request) {
//        Province province = provinceService.save(request);
//        ProvinceWithoutCityDTO dto = mapper.convertToWithoutCity(province);
//        return ResponseEntity.ok(dto);
        return ResponseEntity.ok(
                mapper.convertToWithoutCity(
                        provinceService.save(request)
                )
        );
    }

    @PostMapping
    public ResponseEntity<ProvinceWithoutCityDTO> update(
            @RequestBody @Validated(value = ValidationGroup.Update.class) ProvinceSaveUpdateRequest request) {
//        Province province = provinceService.save(request);
//        ProvinceWithoutCityDTO dto = mapper.convertToWithoutCity(province);
//        return ResponseEntity.ok(dto);
        return ResponseEntity.ok(
                mapper.convertToWithoutCity(
                        provinceService.update(
                                mapper.toProvince(request)
                        )
                )
        );
    }
}
