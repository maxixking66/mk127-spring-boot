package ir.maktabsharif127.main.domain;

import ir.maktabsharif127.main.domain.base.BaseEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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

    public static final String PROVINCE_ID = "province_id";

    private String name;

    @OneToMany
    @JoinColumn(name = PROVINCE_ID)
    private Set<City> cities = new HashSet<>();

    public Province(Long id, String name) {
        this.name = name;
        setId(id);
    }
}
