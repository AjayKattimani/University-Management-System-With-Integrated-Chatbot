package com.exam.spring.jobapplications;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository repo;

    public void addJobApplicants(JobApplication jobApplication) {
        repo.save(jobApplication);
    }
    public void deleteJobApplication(Long id) {
        repo.deleteById(id);
    }

    public List<JobApplication> getAllJobApplications() {
        return repo.findAll();
    }
    public JobApplication getJobApplicationById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
