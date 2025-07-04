package ir.maktabsharif127.main;

import ir.maktabsharif127.main.domain.User;
import ir.maktabsharif127.main.repository.UserRepository;
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
        UserRepository userRepository = run.getBean(UserRepository.class);

        userRepository.save(new User());

//        User user = userRepository.findById(1252L).get();
//
//        user.setFirstName("mohsen");
//        userRepository.save(user);

    }

    @Bean
    public DateTimeProvider dateTimeProvider() {
        return () -> Optional.of(ZonedDateTime.now());
    }
}
