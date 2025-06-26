package ir.maktabsharif127.main.domain.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Setter
@Getter
public class BaseEntity<ID extends Serializable> implements Serializable {

    private ID id;

    private ZonedDateTime createDate;

    private ZonedDateTime lastUpdateDate;

    public BaseEntity() {
        this.createDate = ZonedDateTime.now();
        this.lastUpdateDate = this.createDate;
    }
}
