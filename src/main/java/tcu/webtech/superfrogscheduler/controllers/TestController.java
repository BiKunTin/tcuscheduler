package tcu.webtech.superfrogscheduler.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/customer")
    @PreAuthorize("hasRole('CUSTOMER') or hasRole('SUPERFROG') or hasRole('SPIRITDIRECTOR')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/superfrog")
    @PreAuthorize("hasRole('SUPERFROG')")
    public String moderatorAccess() {
        return "SuperFrog Board.";
    }

    @GetMapping("/spiritdirector")
    @PreAuthorize("hasRole('SPIRITDIRECTOR')")
    public String adminAccess() {
        return "Spirit Director Board.";
    }
}
