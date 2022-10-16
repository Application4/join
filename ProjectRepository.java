package com.javatechie.repository;

import com.javatechie.dto.ProjectEngineerResponseDto;
import com.javatechie.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    @Query("SELECT new com.javatechie.dto.ProjectEngineerResponseDto(p.name , e.name , e.dept) FROM Project p JOIN p.engineers e")
    public List<ProjectEngineerResponseDto> getProjectSpecificEngineer();


}
