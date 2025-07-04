package ir.maktabsharif127.main;

import ir.maktabsharif127.main.dto.RegisterRequest;
import ir.maktabsharif127.main.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "ir.maktabsharif127")
@EnableScheduling
@EnableCaching
public class MaktabApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MaktabApplication.class, args);
        UserService userService = run.getBean(UserService.class);

        userService.register(
                new RegisterRequest(
                        "09121212222",
                        "tom",
                        "123456789"
                )
        );

    }
}
