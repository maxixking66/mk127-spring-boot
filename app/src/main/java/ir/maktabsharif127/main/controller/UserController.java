package ir.maktabsharif127.main.controller;

import ir.maktabsharif127.main.dto.UserBriefDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    //    @GetMapping("/get-all-info")
//    @GetMapping("/{id}/orders")
//    @GetMapping("/{id}/orders/{orderId}")
//    @GetMapping("/{id}/addresses")
//    @GetMapping("/{id}/wallet")
    @GetMapping
    public ResponseEntity<List<UserBriefDTO>> getAllUsers() {
//        return ResponseEntity.ok(
//                List.of(
//                        new UserBriefDTO(1L, "mohsen", "asgari", null, true, null),
//                        new UserBriefDTO(2L, "mohsen", "asgari", null, true, Collections.emptyList()),
//                        new UserBriefDTO(32L, "mohsen", "asgari", new UserBriefDTO(), false, List.of("1", "2"))
//                )
//        );
        return ResponseEntity.status(201)
                .header("my-header", "my-header-value")
                .body(
                        List.of(
                                new UserBriefDTO(1L, "mohsen", "asgari", null, true, null),
                                new UserBriefDTO(2L, "mohsen", "asgari", null, true, Collections.emptyList()),
                                new UserBriefDTO(32L, "mohsen", "asgari", new UserBriefDTO(), false, List.of("1", "2"))
                        )
                );
    }

}