package com.exam.spring.faculty;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.spring.Department;
import com.exam.spring.DepartmentService;


@Controller
public class Facultycontroller {
	
	@Autowired
	private DepartmentService ds;
	@Autowired
	private Facultyservice fs;
	
	@GetMapping("/faculty")
	public String faculty() {
		return "faculty";
	}
	
	@GetMapping("/facultyform")
	public String facultyform(Model m) {
		List<Department> de =ds.showalldeparntment();
		m.addAttribute("de" , de);
		return "addfaculty";
	}
	
	@PostMapping("/savefaculty")
	public String savefaculty(@ModelAttribute Faculty faculty) {
		fs.addfaculty(faculty);
		return "addfaculty";
	}
	
	@GetMapping("/showfaculty")
	public String showfaculty(Model m) {
		List<Faculty> f = fs.showfaculty();
		m.addAttribute("fc" , f);
		return "showfaculty";
		
	}
	
	
	  @GetMapping("/facultyformgetvalueofform/{id}")
	    public String getUpdateFacultyForm(@PathVariable("id") int id, Model model) {
	        Faculty f = fs.showById(id);
	        model.addAttribute("f", f);
	        return "updatefaculty";
	    }

	    @PostMapping("/updatefaculty")
	    public String updateFaculty(@ModelAttribute Faculty faculty, Model model) {
	        fs.updatefaculty(faculty);
	        return "showfaculty"; // Redirect to showfaculty page after updating
	    }


	@PostMapping("/deletefaculty")
	public String deletefaculty(@RequestParam("id") int id, Model m) { // Use @RequestParam to get the ID
	    Faculty f = fs.showById(id);
	    fs.deletefaculty(f);
	    return "redirect:/showfaculty"; // Redirect to the showfaculty page after deleting
	}

		@GetMapping("/searchfaculty")
		public String showById(@ModelAttribute Faculty faculty, Model m) {
		    List<Faculty> ft = new ArrayList<>();
		    Faculty f = fs.showById(faculty.getId());
		    ft.add(f);
		    m.addAttribute("fc", ft); // Update attribute name to match the one in JSP
		    return "showfaculty";
		}

		
	

}