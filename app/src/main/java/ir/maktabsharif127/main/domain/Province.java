package ir.maktabsharif127.main.domain;

import ir.maktabsharif127.main.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Province extends BaseEntity<Long> {

    private String name;

    //    @OneToMany
    private Set<City> cities = new HashSet<>();

    public Province(Long id, String name) {
        this.name = name;
        setId(id);
    }
}
