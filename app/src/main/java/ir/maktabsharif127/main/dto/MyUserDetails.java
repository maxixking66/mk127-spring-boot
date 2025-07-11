package ir.maktabsharif127.main.dto;

import ir.maktabsharif127.main.domain.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class MyUserDetails implements UserDetails {

    @Getter
    private final User user;

    private final Collection<GrantedAuthority> authorities = new ArrayList<>();

    public MyUserDetails(User user) {
        this.user = user;
        fillAuthorities();
    }

    private void fillAuthorities() {
        if (user.getRoles() != null && !user.getRoles().isEmpty()) {
            user.getRoles().forEach(role -> {
                authorities.add(
                        new SimpleGrantedAuthority(role.getName())
                );
                if (role.getAuthorities() != null && !role.getAuthorities().isEmpty()) {
                    role.getAuthorities().forEach(
                            authority -> authorities.add(
                                    new SimpleGrantedAuthority(authority.getName())
                            )
                    );
                }
            });
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isEnabled() {
        return user.getIsActive();
    }
}
