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
			job1.setDate("12.3.2024");
			job1.setCompany_Name("INTEL");
			job1.setJob_Title("BACKEND");
			job1.setLink("www.google.com");
			job1.setThrough_whom("linkedin");
			job1.setComments("Want's AWS.");
			JobModelAttribute job2 = new JobModelAttribute();
			job2.setDate("11.4.2024");
			job2.setCompany_Name("PIZZA");
			job2.setJob_Title("DELIVERY");
			job2.setLink("www.google.com");
			job2.setThrough_whom("linkedin");
			job2.setComments("HIGH SALARY.");
			JobModelAttribute job3 = new JobModelAttribute();
			job3.setDate("30.1.2024");
			job3.setCompany_Name("Apple");
			job3.setJob_Title("Steve Jobs");
			job3.setLink("www.apple.com");
			job3.setThrough_whom("Grandpa");
			job3.setComments("Iphone.");
			jobsService.add_job(job1);
			jobsService.add_job(job2);
			jobsService.add_job(job3);
			assertThat(jobsService.find_all_jobs().size() == 3).isTrue();
			jobsService.delete_job(job1.getId());
			assertThat(jobsService.find_all_jobs().size() == 2).isTrue();
			assertThat(job2.toString().equals("JobModelAttribute{" +
					"Id=" + job2.getId() +
					", Date='" + job2.getDate() + '\'' +
					", Company_Name='" + job2.getCompany_Name() + '\'' +
					", Job_Title='" + job2.getJob_Title() + '\'' +
					", Link='" + job2.getLink() + '\'' +
					", through_whom='" + job2.getThrough_whom() + '\'' +
					", Comments='" + job2.getComments() + '\'' +
					'}')).isTrue();

		}
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		System.out.println("TESTS FINISHED");
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
	}
}
