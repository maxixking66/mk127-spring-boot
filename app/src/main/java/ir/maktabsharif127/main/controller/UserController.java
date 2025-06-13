package ir.maktabsharif127.main.controller;

import ir.maktabsharif127.main.dto.UserBriefDTO;
import ir.maktabsharif127.main.dto.UserInsertRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<UserBriefDTO>> getAllUsers() {
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

    @GetMapping("/by-param")
//    requestParam, query string, Query Params -> /users?id=5&username=mohsen&
    public ResponseEntity<UserBriefDTO> getUserById(@RequestParam Long id) {
        return ResponseEntity.ok(
                new UserBriefDTO(id, "mohsen", "asgari", null, true, null)
        );
    }

    @GetMapping("/by-path-variable/{id}")
//    /users/5/orders
    public ResponseEntity<UserBriefDTO> getUserByIdAndPath(@PathVariable Long id) {
        return ResponseEntity.ok(
                new UserBriefDTO(id, "mohsen", "asgari", null, true, null)
        );
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody @Valid UserInsertRequest request) {
        System.out.println(request);
        return ResponseEntity.ok(request);
    }

}