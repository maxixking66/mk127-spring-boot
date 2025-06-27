package ir.maktabsharif127.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ir.maktabsharif127")
public class MaktabApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaktabApplication.class, args);
        System.out.println("in main");
    }
}
