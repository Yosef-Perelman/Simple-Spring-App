package com.example.simple_spring_app.controller;

import com.example.simple_spring_app.modelAttribute.JobModelAttribute;
import com.example.simple_spring_app.service.JobService;
import com.example.simple_spring_app.service.JobsServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    private JobsServiceInterface jobsService;

    public IndexController() {
        this.jobsService = new JobService();
        JobModelAttribute job1 = new JobModelAttribute();
//        job1.setId(1);
//        job1.setComments("hi");
//        job1.setDate("12345");
//        job1.setLink("sdfsdf");
//        job1.setCompany_Name("sdfsd");
//        job1.setThrough_whom("me");
//        job1.setJob_Title("hi");
//        jobsService.add_job(job1);
    }

    @RequestMapping(value={"", "/", "/index", "/index.html"})
    public String home_page(Model model) {
        List<JobModelAttribute> jobs = jobsService.find_all_jobs();
        model.addAttribute("jobs", jobs);
        return "index";
    }

    @RequestMapping("/add")
    public String addJobShowForm(Model model){
        model.addAttribute("jobModelAttribute", new JobModelAttribute());
        return "add";
    }

    @PostMapping("/add-job")
    public String addJob(@ModelAttribute("JobModelAttribute") JobModelAttribute jobModelAttribute) {
        this.jobsService.add_job(jobModelAttribute);
        return "redirect:/";
    }

}
