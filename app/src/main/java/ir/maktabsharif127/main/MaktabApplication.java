package ir.maktabsharif127.main;

import ir.maktabsharif127.main.repository.UserRepository;
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
        UserRepository userRepository = run.getBean(UserRepository.class);

//        System.out.println(userRepository.findAllByIdIsNotNull(NamesOnly.class).size());
//        System.out.println(userRepository.findAllByIdIsNotNull(CredentialOnly.class).size());
        System.out.println(userRepository.findAllCustom().size());
        System.out.println(userRepository.findAllCustomV2().size());

    }
}
