package com.exam.spring.jobapplications;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class JobApplicationController {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    private JobApplicationService js;
    @PostMapping("/confirm")
    public String handleFormSubmit(@RequestParam("firstName") String firstName,
                                  @RequestParam("lastName") String lastName,
                                  @RequestParam("dateOfBirth") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOfBirth,
                                  @RequestParam("mobileNumber") String mobileNumber,
                                  @RequestParam("jobPosition") String jobPosition,
                                  @RequestParam("experience") Integer experience,
                                  @RequestParam("resume") MultipartFile resume,
                                  RedirectAttributes redirectAttributes) {

        JobApplication jobApplication = new JobApplication();
        jobApplication.setFirstName(firstName);
        jobApplication.setLastName(lastName);
        jobApplication.setDateOfBirth(dateOfBirth);
        jobApplication.setMobileNumber(mobileNumber);
        jobApplication.setJobPosition(jobPosition);
        jobApplication.setExperience(experience);

        if (!resume.isEmpty()) {
            try {
                InputStream inputStream = resume.getInputStream();
                byte[] resumeBytes = inputStream.readAllBytes();
                jobApplication.setResume(resumeBytes);
            } catch (IOException e) {
                e.printStackTrace();
                redirectAttributes.addFlashAttribute("error", "Failed to upload file.");
                return "redirect:/apply"; // Redirect back to form if file upload fails
            }
        }

        jobApplicationRepository.save(jobApplication);

        redirectAttributes.addFlashAttribute("message", "Application submitted successfully!");
        return "confirmation"; // Ensure this path is correctly handled
    }


    @GetMapping("/apply")
    public String showJobApplication() {
        return "apply";     
        }
    
    @GetMapping("/showjobapplications")
    public String showJobApplications(Model model) {
        List<JobApplication> jobApplications = js.getAllJobApplications();
        model.addAttribute("jobApplications", jobApplications);
        return "showjobapplications";
    }

    @PostMapping("/deletejobapplication")
    public String deleteJobApplication(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        js.deleteJobApplication(id);
        redirectAttributes.addFlashAttribute("message", "Job application deleted successfully!");
        return "redirect:/showjobapplications";
    }

    @GetMapping("/viewresume/{id}")
    @ResponseBody
    public ResponseEntity<InputStreamResource> viewResume(@PathVariable("id") Long id) throws IOException {
        JobApplication jobApplication = js.getJobApplicationById(id);
        if (jobApplication == null || jobApplication.getResume() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        InputStream inputStream = new ByteArrayInputStream(jobApplication.getResume());
        InputStreamResource resource = new InputStreamResource(inputStream);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"resume_" + id + ".pdf\"")
                .contentLength(jobApplication.getResume().length)
                .body(resource);
    }
    

   /* @PostMapping("/deletejobapplication")
    public String deleteJobApplication(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
    	js.deleteJobApplication(id); // Use service to delete by ID
        redirectAttributes.addFlashAttribute("message", "Job application deleted successfully!");
        return "redirect:/showjobapplications"; // Redirect to the job applications list
    }

    @GetMapping("/showjobapplications")
    public String showJobApplications(Model model) {
        List<JobApplication> applications = js.getAllJobApplications(); // Fetch all job applications
        model.addAttribute("applications", applications); // Add to model for view
        return "showjobapplications"; // Return view name
    }*/
}