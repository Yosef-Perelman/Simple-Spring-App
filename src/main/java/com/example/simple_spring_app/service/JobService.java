package com.example.simple_spring_app.service;

import com.example.simple_spring_app.modelAttribute.JobModelAttribute;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService implements JobsServiceInterface{

    private List<JobModelAttribute> jobs;

    public JobService() {
        jobs = new ArrayList<JobModelAttribute>();
    }

    @Override
    public void add_job(JobModelAttribute jobModelAttribute){
        jobs.add(jobModelAttribute);
    }

    @Override
    public void delete_job(int id){}

    @Override
    public List<JobModelAttribute> find_all_jobs(){
        return jobs;
    }
}
