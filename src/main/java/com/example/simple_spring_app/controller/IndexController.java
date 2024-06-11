package com.example.simple_spring_app.controller;

import com.example.simple_spring_app.modelAttribute.JobModelAttribute;
import com.example.simple_spring_app.service.JobService;
import com.example.simple_spring_app.service.JobsServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    private JobsServiceInterface jobsService;

    public IndexController(JobsServiceInterface jobsService) {
        this.jobsService = jobsService;
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

    @PostMapping("/delete-job/{id}")
    public String deleteJob(@PathVariable int id) {
        this.jobsService.delete_job(id);
        return "redirect:/";
    }
}
