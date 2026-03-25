package com.exam.spring.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Add GET mapping for the login page
    @GetMapping("/adminlogin")
    public String showLoginPage() {
        return "admin-login";
    }

    @PostMapping("/adminlogin")
    public String login(@RequestParam("email") String email, 
                        @RequestParam("password") String password, 
                        Model model) {
        Admin admin = adminService.authenticate(email, password);
        if (admin != null) {
            return "admin-panel";
        } else {
            model.addAttribute("errorMessage", "Invalid email or password");
            return "admin-login";
        }
    }
}