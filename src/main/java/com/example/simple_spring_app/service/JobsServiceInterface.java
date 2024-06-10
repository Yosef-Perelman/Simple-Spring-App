package com.example.simple_spring_app.service;

import com.example.simple_spring_app.modelAttribute.JobModelAttribute;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobsServiceInterface {

    void add_job(JobModelAttribute jobModelAttribute);

    List<JobModelAttribute> find_all_jobs();

}
