package ir.maktabsharif127.main;

import ir.maktabsharif127.main.repository.CityRepository;
import ir.maktabsharif127.main.repository.ProvinceRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "ir.maktabsharif127")
public class MaktabApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MaktabApplication.class, args);

        System.out.println(
                "province count: " + run.getBean(ProvinceRepository.class).count()
        );
        System.out.println(
                "city count: " + run.getBean(CityRepository.class).count()
        );
    }
}
