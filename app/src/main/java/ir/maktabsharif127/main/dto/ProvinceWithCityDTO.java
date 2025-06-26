package ir.maktabsharif127.main.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProvinceWithCityDTO implements Serializable {

    private Long id;

    private String name;

    private Set<CityDTO> cities;
}
