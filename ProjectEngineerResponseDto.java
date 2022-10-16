package com.javatechie.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectEngineerResponseDto {

    private String projectName;

    private String employeeName;

    private String dept;

    private int count;

    public ProjectEngineerResponseDto(String projectName, String employeeName, String dept) {
        this.projectName = projectName;
        this.employeeName = employeeName;
        this.dept = dept;
    }

    public ProjectEngineerResponseDto(String projectName, int count) {
        this.projectName = projectName;
        this.count = count;
    }
}
