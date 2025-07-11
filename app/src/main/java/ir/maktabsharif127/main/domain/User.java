package ir.maktabsharif127.main.domain;

import ir.maktabsharif127.main.domain.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = User.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraph(name = User.FULL_GRAPH, attributeNodes = {

})
public class User extends BaseEntity<Long> {

    public static final String TABLE_NAME = "tbl_users";
    public static final String FULL_GRAPH = "user_full_graph";

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String mobileNumber;
    private ZonedDateTime birthdate;
    private Boolean isActive = true;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();
}
