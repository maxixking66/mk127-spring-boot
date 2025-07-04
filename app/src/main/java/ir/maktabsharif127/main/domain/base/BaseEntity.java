package ir.maktabsharif127.main.domain.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity<ID extends Serializable> implements Serializable {

    public static final String ID = "id";
    public static final String CREATE_DATE = "create_date";
    public static final String LAST_UPDATE_DATE = "last_update_date";

    @Id
    @GeneratedValue
    @Column(name = ID)
    private ID id;

    @Column(name = CREATE_DATE)
    @CreatedDate
    private LocalDateTime createDate;

    @Column(name = LAST_UPDATE_DATE)
    @LastModifiedDate
    private LocalDateTime lastUpdateDate;

//    public BaseEntity() {
//        this.createDate = ZonedDateTime.now();
//        this.lastUpdateDate = this.createDate;
//    }
}
