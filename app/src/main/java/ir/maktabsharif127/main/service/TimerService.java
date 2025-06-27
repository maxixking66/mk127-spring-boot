package ir.maktabsharif127.main.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TimerService {

    @Scheduled(cron = "*/5 * * ? * *")
    public void printTime() {
        System.out.println(LocalDateTime.now());
    }

    @Scheduled(cron = "15 0 0 ? * *")
    public void expire() {
        System.out.println("in expire");
    }
}
