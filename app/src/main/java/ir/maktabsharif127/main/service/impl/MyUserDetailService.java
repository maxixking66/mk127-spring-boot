package ir.maktabsharif127.main.service.impl;

import ir.maktabsharif127.main.dto.MyUserDetails;
import ir.maktabsharif127.main.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new MyUserDetails(
                userService.findByUsername(username)
                        .orElseThrow(
                                () -> new UsernameNotFoundException("not found")
                        )
        );
    }
}
