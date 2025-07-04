package ir.maktabsharif127.main;

import ir.maktabsharif127.main.domain.Role;
import ir.maktabsharif127.main.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "ir.maktabsharif127")
@EnableScheduling
@EnableCaching
public class MaktabApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaktabApplication.class, args);
        System.out.println("in main");
    }

    @Bean
    CommandLineRunner runner(RoleService roleService) {
        return a -> {
            Role role = new Role();
            role.setName("ADMIN");
            roleService.save(role);
        };
    }
}
