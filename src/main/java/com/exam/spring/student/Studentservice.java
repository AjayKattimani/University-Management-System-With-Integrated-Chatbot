package com.exam.spring.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Studentservice {

    @Autowired
    private StudentInterfaceRep sr;
    
    public Student authenticate(String email, String password) {
        Student student = sr.findByEmail(email);
        if (student != null && student.getPassword().equals(password)) {
            return student;
        }
        return null;
    }

    public void addstudent(Student s) {
        sr.save(s);
    }

    public void updatestudent(Student s) {
        sr.save(s);
    }

    public void deletestudent(Student s) {
        sr.delete(s);
    }

    public List<Student> showallstudent() {
        return sr.findAll();
    }

    public Student showbyid(int id) {
        return sr.findById(id).orElse(null);
    
        
    }

	
}
