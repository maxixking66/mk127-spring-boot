package ir.maktabsharif127.main;

import ir.maktabsharif127.main.config.HttpRequestsCustomizer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.ZonedDateTime;
import java.util.Optional;

@SpringBootApplication(scanBasePackages = "ir.maktabsharif127")
@EnableScheduling
@EnableCaching
@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
public class MaktabApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MaktabApplication.class, args);


    }

    @Bean
    public DateTimeProvider dateTimeProvider() {
        return () -> Optional.of(ZonedDateTime.now());
    }

    @Bean
    public HttpRequestsCustomizer customizer() {
        return new HttpRequestsCustomizer() {
            @Override
            public String[] permitAll() {
//                return new String[]{"/api/free/now", "/api/free/other"};
                return new String[]{"/api/free/**"};
            }
        };
    }
}
