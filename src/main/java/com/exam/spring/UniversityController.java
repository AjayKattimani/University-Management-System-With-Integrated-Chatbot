package com.exam.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.exam.spring.assignstudent.Assignstudent;
import com.exam.spring.assignstudent.Assignstudentservice;
import com.exam.spring.student.Student;
import com.exam.spring.student.Studentservice;

@Controller
public class UniversityController {

    @Autowired
    private Universityservice us;

    @Autowired
    private Studentservice ss;

    @Autowired
    private Assignstudentservice as;

    // Login start
    @GetMapping("/sbwebpage")
    public String showUniversityWebPage() {
    	 System.out.println("Controller hit");
        return "sharnbasva"; // Assuming "sharnbasva" is the name of your university web page
    }
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/studentlogin")
    public String student() {
        return "studentdeshboard";
    }

    @GetMapping("/facultylogin")
    public String faculty() {
        return "Facultydeshboard";
    }

    @GetMapping("/adduniversity")
    public String university() {
        return "adduniversity";
    }

    @PostMapping("/save")
    public String saveuniversity(@ModelAttribute University universtiy, Model m) {
        us.adduniversity(universtiy);

        String s = "Add university successfully";
        m.addAttribute("s", s);
        return "adduniversity";
    }

    // create Admit card

    @GetMapping("/AdmitCard")
    public String admitcard() {
        return "createadmitcard";
    }

    @PostMapping("/createAdmitCard")
    public String createadmitcard(@ModelAttribute Student student, @ModelAttribute Assignstudent ast, Model m) {
        student = ss.showbyid(student.getId());
        m.addAttribute("st", student);
        ast = as.showbyid(ast.getId());
        m.addAttribute("ast", ast);

        return "admitcard";
    }
    @GetMapping("/notifications")
    public String Notifications() {
    	return "notification";
    }
    @GetMapping("/careers")
    public String Careers() {
    	return "career";
    }
    
   
    
}
