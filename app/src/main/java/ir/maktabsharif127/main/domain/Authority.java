package ir.maktabsharif127.main.domain;

import ir.maktabsharif127.main.domain.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Authority.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Authority extends BaseEntity<Integer> {

    public static final String TABLE_NAME = "tbl_authorities";

    public static final String NAME = "name";

    @Column(name = NAME)
    private String name;
}
