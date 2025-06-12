package ir.maktabsharif127.main;

import ir.maktabsharif127.util.UtilService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "ir.maktabsharif127")
public class MaktabApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MaktabApplication.class, args);

        UtilService bean = run.getBean(UtilService.class);

    }
}
