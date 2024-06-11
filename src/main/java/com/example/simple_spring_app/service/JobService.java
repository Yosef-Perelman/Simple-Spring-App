package com.example.simple_spring_app.service;

import com.example.simple_spring_app.modelAttribute.JobModelAttribute;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Date;

@Service
public class JobService implements JobsServiceInterface{

    private List<JobModelAttribute> jobs;

    public JobService() {
        jobs = new ArrayList<JobModelAttribute>();
    }

    @Override
    public void add_job(JobModelAttribute jobModelAttribute){
        jobModelAttribute.setId(jobs.size() + 1);
        SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
        String str = ft.format(new Date());
        jobModelAttribute.setDate(str);
        //jobModelAttribute.setLink((String)jobModelAttribute.getLink());
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
