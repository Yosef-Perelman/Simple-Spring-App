package com.example.simple_spring_app;

import com.example.simple_spring_app.controller.IndexController;
import com.example.simple_spring_app.service.JobsServiceInterface;
import com.example.simple_spring_app.modelAttribute.JobModelAttribute;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SimpleSpringAppApplicationTests {

	@Autowired
	private JobsServiceInterface jobsService;

	@Test
	void contextLoads() {
		assertThat(jobsService).isNotNull();

		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		System.out.println("STARTING TESTS");
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		if (jobsService.find_all_jobs().isEmpty()) {
			JobModelAttribute job1 = new JobModelAttribute();
			job1.setId(1);
			job1.setDate("12.3.2024");
			job1.setCompany_Name("INTEL");
			job1.setJob_Title("BACKEND");
			job1.setLink("www.google.com");
			job1.setThrough_whom("linkedin");
			job1.setComments("Want's aws.");
			JobModelAttribute job2 = new JobModelAttribute();
			job1.setId(2);
			job1.setDate("11.4.2024");
			job1.setCompany_Name("PIZZA");
			job1.setJob_Title("DELIVERY");
			job1.setLink("www.google.com");
			job1.setThrough_whom("linkedin");
			job1.setComments("HIGH SALARY.");
			JobModelAttribute job3 = new JobModelAttribute();
			job1.setId(3);
			job1.setDate("30.1.2024");
			job1.setCompany_Name("sdfsd");
			job1.setJob_Title("hi");
			job1.setLink("www.google.com");
			job1.setThrough_whom("linkedin");
			job1.setComments("Want's aws.");


		}
	}

}
