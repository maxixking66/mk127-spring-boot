package ir.maktabsharif127.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/", ""})
public class PageController {

    @GetMapping
    public String getHome() {
        return "index";
    }

    @GetMapping("/dashboard")
    public String getDashboard() {
        return "dashboard";
    }
}
