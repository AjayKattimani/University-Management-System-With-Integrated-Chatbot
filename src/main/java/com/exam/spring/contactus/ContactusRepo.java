package com.exam.spring.contactus;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactusRepo extends JpaRepository<Contactus, Long> {

}
