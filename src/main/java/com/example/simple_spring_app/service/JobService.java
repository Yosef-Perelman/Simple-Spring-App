package com.example.simple_spring_app.service;

import com.example.simple_spring_app.modelAttribute.JobModelAttribute;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JobService implements JobsServiceInterface{

    private List<JobModelAttribute> jobs;

    public JobService() {
        jobs = new ArrayList<JobModelAttribute>();
    }

    @Override
    public void add_job(JobModelAttribute jobModelAttribute){
        jobModelAttribute.setId(jobs.size() + 1);
        jobs.add(jobModelAttribute);
    }

    @Override
    public void delete_job(int id){
        Iterator<JobModelAttribute> itr = jobs.iterator();
        while (itr.hasNext()){
            if (itr.next().getId() == id) {
                itr.remove();
                break;
            }
        }
        itr = jobs.iterator();
        int index = 1;
        while (itr.hasNext()){
            itr.next().setId(index);
            index++;
        }
    }

    @Override
    public List<JobModelAttribute> find_all_jobs(){
        return jobs;
    }
}
