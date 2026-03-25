package com.exam.spring.Semester;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.exam.spring.Department;
import com.exam.spring.DepartmentService;

@Controller
public class SemesterController {

    @Autowired
    private SemesterService ss;

    @Autowired
    private DepartmentService ds;

    @GetMapping("/Semester")
    public String semester() {
        return "Semester";
    }

    @GetMapping("/addsemesterform")
    public String semesterform(Model m) {
        List<Department> d = ds.showalldeparntment();
        m.addAttribute("d", d);
        return "addsemester";
    }

    @PostMapping("/addsementer")
    public String addsementer(@ModelAttribute Semester semester) {
        ss.addsemester(semester);
        return "addsemester";
    }

    @GetMapping("/showsemester")
    public String showsemester(Model m) {
        List<Semester> se = ss.showallsemester();
        m.addAttribute("se", se);
        return "showsemester";
    }

    @GetMapping("/deletesemester/{semestercode}")
    public String deletesemester(@PathVariable int semestercode, Model m) {
        Semester s = ss.showbyid(semestercode);
        ss.deletesemester(s);
        m.addAttribute("se", ss.showallsemester());
        return "showsemester";
    }

    @GetMapping("/getvalueupdateform/{semestercode}")
    public String getvalueupdateform(@PathVariable("semestercode") int semestercode, Model m) {
        Semester s = ss.showbyid(semestercode);
        m.addAttribute("sm", s);
        return "semesterupdate";
    }

    @PostMapping("/updatesemester")
    public String updatesemester(@ModelAttribute Semester semester, Model m) {
        ss.updatesemester(semester);
        m.addAttribute("se", ss.showallsemester());
        return "showsemester";
    }

    @PostMapping("/searchsemester")
    public String showById(@ModelAttribute Semester semester, Model m) {
        List<Semester> s = new ArrayList<>();
        Semester se = ss.showbyid(semester.getSemestercode());
        s.add(se);
        m.addAttribute("se", s);
        return "showsemester";
    }
}
