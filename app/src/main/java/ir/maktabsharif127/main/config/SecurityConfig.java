package ir.maktabsharif127.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


//    @Bean
//    @ConditionalOnMissingBean
//    public HttpRequestsCustomizer httpRequestsCustomizer() {
//        return new HttpRequestsCustomizer() {
//        };
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, HttpRequestsCustomizer httpRequestsCustomizer) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        (requests) -> {
                            String[] permitAll = httpRequestsCustomizer.permitAll();
                            if (permitAll != null && permitAll.length > 0) {
                                requests.requestMatchers(permitAll)
                                        .permitAll();
                            }
                            Collection<HttpRequestsCustomizer.AuthorityBased> authorityBaseds = httpRequestsCustomizer.authorizeByAuthority();
                            if (authorityBaseds != null && !authorityBaseds.isEmpty()) {
                                authorityBaseds.forEach(data -> requests.requestMatchers(data.urls())
                                        .hasAnyAuthority(data.authorities()));
                            }
                            requests.anyRequest().authenticated();
                        }
                )
                .httpBasic(withDefaults()).build();
    }
}
