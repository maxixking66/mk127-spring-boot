package ir.maktabsharif127.main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("/api/free")
public class FreeController {

    @GetMapping("/now")
    public ResponseEntity<ZonedDateTime> now() {
        return ResponseEntity.ok(
                ZonedDateTime.now()
        );
    }

    @GetMapping("/other")
    public ResponseEntity<ZonedDateTime> other() {
        return ResponseEntity.ok(
                ZonedDateTime.now()
        );
    }
}
