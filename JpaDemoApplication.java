package com.javatechie;

import com.javatechie.common.AuditorAwareImpl;
import com.javatechie.dto.ProjectEngineerResponseDto;
import com.javatechie.entity.Engineer;
import com.javatechie.entity.Product;
import com.javatechie.entity.Project;
import com.javatechie.repository.EngineerRepository;
import com.javatechie.repository.ProductRepository;
import com.javatechie.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
//@RequestMapping("/products")
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableJpaRepositories(repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class JpaDemoApplication {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EngineerRepository engineerRepository;



    //association mapping demo
    @PostMapping("/projects")
    public Project addNewProject(@RequestBody Project project){
        return projectRepository.save(project);
    }

    @GetMapping("/projects")
    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    @DeleteMapping("/project/{id}")
    public String deleteProject(@PathVariable int id){
        projectRepository.deleteById(id);
        return "Project id "+id+" deleted !";
    }

    @GetMapping("/engineer")
    public List<Engineer> findAllEngineers(){
        return engineerRepository.findAll();
    }

    @GetMapping("/test1")
    public List<ProjectEngineerResponseDto> results(){
        return projectRepository.getProjectSpecificEngineer();
    }




    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Bean
    public AuditorAware<String> auditorAware(){
        return new AuditorAwareImpl();
    }

}
