package com.exam.spring.assigncourse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssigncourseRepo extends JpaRepository<Assigncourse, Integer> {
	
}
