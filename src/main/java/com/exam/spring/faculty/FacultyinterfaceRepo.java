package com.exam.spring.faculty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyinterfaceRepo extends JpaRepository<Faculty, Integer> {
    
    @Query("SELECT f FROM Faculty f WHERE f.id = :id")
    public Faculty showById(@Param("id") Integer id);
}

