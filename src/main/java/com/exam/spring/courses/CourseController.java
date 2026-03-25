package com.exam.spring.courses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.exam.spring.Semester.Semester;
import com.exam.spring.Semester.SemesterService;

@Controller
public class CourseController {

    @Autowired
    private CourseService cs;

    @Autowired
    private SemesterService ss;

    @GetMapping("/course")
    public String course() {
        return "course";
    }

    @GetMapping("/addcourse")
    public String addcourse(Model m) {
        List<Semester> s = ss.showallsemester();
        m.addAttribute("co", s);
        return "addcourse";
    }

    @PostMapping("/addcourseinfo")
    public String addcourseinfo(@ModelAttribute Course course) {
        cs.addcourse(course);
        return "addcourse";
    }

    @GetMapping("/showcourse")
    public String showcourser(Model m) {
        List<Course> c = cs.showallcourse();
        m.addAttribute("co", c);
        return "showcourse";
    }
    
    
    @GetMapping("/courseformgetvalueofform/{id}")
    public String getUpdateCourseForm(@PathVariable("id") int coursecode, Model model) {
        Course c = cs.showById(coursecode);
        model.addAttribute("f", c);
        return "updatecourse";
    }

    @PostMapping("/updatecourse")
    public String updateCourse(@ModelAttribute Course course, Model model) {
        cs.updatecourse(course);
        return "showcourse"; // Redirect to showfaculty page after updating
    }


@PostMapping("/deletecourse")
public String deletefaculty(@RequestParam("id") int id, Model m) { // Use @RequestParam to get the ID
    Course c = cs.showById(id);
    cs.deletecourse(c);
    return "redirect:/showcourse"; // Redirect to the showfaculty page after deleting
}
    
    
        @GetMapping("/searchcourse")
		public String CourseshowById(@ModelAttribute Course course, Model m) {
		    List<Course> sc = new ArrayList<>();
		    Course c = cs.showById(course.getCoursecode());
		    sc.add(c);
		    m.addAttribute("sc",sc ); // Update attribute name to match the one in JSP
		    return "showcourse";
		
    }
}
