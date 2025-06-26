package ir.maktabsharif127.main.mapper;

import ir.maktabsharif127.main.domain.City;
import ir.maktabsharif127.main.domain.Province;
import ir.maktabsharif127.main.dto.CityDTO;
import ir.maktabsharif127.main.dto.ProvinceWithCityDTO;
import ir.maktabsharif127.main.dto.ProvinceWithoutCityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProvinceMapper {


    List<ProvinceWithCityDTO> convertToWithCity(List<Province> provinces);


    List<ProvinceWithoutCityDTO> convertToWithoutCity(List<Province> provinces);

    List<CityDTO> convertToCityDTOs(Set<City> cities);
}
