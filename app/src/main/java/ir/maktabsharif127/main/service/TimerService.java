package ir.maktabsharif127.main.service;

import ir.maktabsharif127.main.service.impl.ProvinceServiceImpl;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TimerService {

    @Scheduled(cron = "*/10 * * ? * *")
    @CacheEvict(value = ProvinceServiceImpl.CACHE_NAME, key = ProvinceServiceImpl.COUNT_CACHE_KEY)
    public void printTime() {
        System.out.println(LocalDateTime.now());
    }

    @Scheduled(cron = "15 0 0 ? * *")
    public void expire() {
        System.out.println("in expire");
    }
}
