package com.javatechie.repository;

import com.javatechie.entity.Engineer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineerRepository extends JpaRepository<Engineer,Integer> {
}
