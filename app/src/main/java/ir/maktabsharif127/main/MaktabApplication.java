package ir.maktabsharif127.main;

import com.external.api.service.ExternalService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "ir.maktabsharif127")
public class MaktabApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MaktabApplication.class, args);

        ExternalService externalService = run.getBean(ExternalService.class);
        externalService.callApi();

    }

    @Bean
    public ExternalService myExternalService() {
        return () -> System.out.println("my api call");
    }
}
