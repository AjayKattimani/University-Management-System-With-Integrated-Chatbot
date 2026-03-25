package com.exam.spring.studentpayment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.exam.spring.Semester.Semester;
import com.exam.spring.Semester.SemesterService;
import com.exam.spring.adminpayment.AdminPayment;
import com.exam.spring.adminpayment.AdminPaymentRepo;

@Controller
public class StudentPaymentController {
    
    @Autowired
    private SemesterService ss;
    
    @Autowired
    private AdminPaymentRepo ar;
    
    @Autowired
    private StudentPaymentService sps;
    
    @GetMapping("/studentpayment")
    public String studentpayment(Model m) {
        List<Semester> st = ss.showallsemester();
        m.addAttribute("st", st);
        return "studentpayment";
    }
    
    @PostMapping("/studentpaymentinfo")
    public String getStudentPayment(@RequestParam Integer id, @RequestParam String semestername, Model m) {
        AdminPayment ap = ar.findByIDAndSemesterName(id, semestername);
        m.addAttribute("ap", ap);
        return "studentpaymenttable";
    }
    
    @PostMapping("/savestudentpayment")
    public String savepayment(@ModelAttribute StudentPayment studentpayment) {
        sps.savepayment(studentpayment);
        return "studentpayment";
    }
}
