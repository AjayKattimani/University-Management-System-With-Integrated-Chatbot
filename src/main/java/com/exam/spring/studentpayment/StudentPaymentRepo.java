package com.exam.spring.studentpayment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentPaymentRepo extends JpaRepository<StudentPayment, Integer>{
	
	

}
