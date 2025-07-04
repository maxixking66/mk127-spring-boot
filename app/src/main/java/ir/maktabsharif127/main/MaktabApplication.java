package ir.maktabsharif127.main;

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
}
