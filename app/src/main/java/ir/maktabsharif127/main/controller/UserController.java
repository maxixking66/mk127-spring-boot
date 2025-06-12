package ir.maktabsharif127.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {


    //    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    @GetMapping
    public String getAllUsers() {
        return "this is all users data";
    }

    //    @RequestMapping(path = {"", "/"}, method = RequestMethod.POST)
    @PostMapping
    public String createNewUser() {
        return "this is all users data";
    }

}

//   GET /users
//   POST /users
//   PUT /users
//   DELETE /users
//   GET /users/{id}
//   GET /users http/1.1
//   GET /users/2/orders http/1.1