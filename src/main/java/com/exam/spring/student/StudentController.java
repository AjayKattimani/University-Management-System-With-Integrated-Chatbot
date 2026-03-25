package com.exam.spring.student;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.exam.spring.Department;
import com.exam.spring.DepartmentService;

@Controller
public class StudentController {
    private final StudentInterfaceRep studentRepository;

    @Autowired
    private Studentservice ss;

    @Autowired
    private DepartmentService ds;

    @Value("${student.photos.upload.dir}")
    private String uploadDir;

    public StudentController(StudentInterfaceRep studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/studentLogin")
    public String loginForm() {
        return "studentLogin";
    }

    @PostMapping("/studentLogin")
    public String login(@RequestParam("email") String email, 
                        @RequestParam("password") String password, 
                        Model model) {
        Student student = ss.authenticate(email, password);
        if (student != null) {
            model.addAttribute("student", student);
            return "studentdeshboard";
        } else {
            model.addAttribute("errorMessage", "Invalid email or password");
            return "studentLogin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/studentLogin";
    }

    @GetMapping("/studentform")
    public String studentform() {
        return "student";
    }

    @GetMapping("/addstudentform")
    public String addstudentform(Model m) {
        List<Department> d = ds.showalldeparntment();
        m.addAttribute("de", d);
        return "addstudent";
    }

    @PostMapping("/addstudent")
    public String addstudent(@ModelAttribute Student student) { 
                            // @RequestParam("photo") MultipartFile photoFile) 
    		
        // String photoPath = savePhoto(photoFile);
            //student.setPhoto(photoPath);
            String generatedPassword = UUID.randomUUID().toString();
            student.setPassword(generatedPassword);  // Set the generated password
            ss.addstudent(student);
        return "addstudent";
    }

    @GetMapping("/showstudent")
    public String showstudent(Model m) {
        List<Student> st = ss.showallstudent();
        m.addAttribute("st", st);
        return "showstudent";
    }

    @GetMapping("/studentformgetvalue/{id}")
    public String datagetupdateform(@PathVariable("id") int id, Model m) {
        Student s = ss.showbyid(id);
        m.addAttribute("s", s);
        return "studentupdate";
    }

    @PostMapping("/studentupdate")
    public String studentupdate(@ModelAttribute Student student, 
                                @RequestParam(value = "photo", required = false) MultipartFile photoFile, 
                                Model m) {
        try {
            if (photoFile != null && !photoFile.isEmpty()) {
                String photoPath = savePhoto(photoFile);
                student.setPhoto(photoPath);
            }
            ss.updatestudent(student);
            m.addAttribute("st", ss.showallstudent());
        } catch (IOException e) {
            e.printStackTrace();
            // Handle error
        }
        return "showstudent";
    }

    @GetMapping("/deletestudent/{id}")
    public String deletestudent(@PathVariable("id") int id, Model m) {
        Student s = ss.showbyid(id);
        ss.deletestudent(s);
        m.addAttribute("st", ss.showallstudent());
        return "showstudent";
    }

    @PostMapping("/searchstudent")
    public String showById(@ModelAttribute Student student, Model m) {
        List<Student> st = new ArrayList<>();
        Student s = ss.showbyid(student.getId());
        st.add(s);
        m.addAttribute("st", st);
        return "showstudent";
    }

    private String savePhoto(MultipartFile photoFile) throws IOException {
        if (!photoFile.isEmpty()) {
            String fileName = UUID.randomUUID().toString() + "_" + photoFile.getOriginalFilename();
            Path filePath = Paths.get(uploadDir, fileName);
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, photoFile.getBytes());
            return filePath.toString();
        }
        return null;
    }
}
