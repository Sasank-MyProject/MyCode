package com.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.taskmanager.domain.Label;
import com.taskmanager.domain.Task;
import com.taskmanager.repository.LabelRepository;
import com.taskmanager.repository.TaskManRepository;

@SpringBootApplication
public class TaskmanagerApplication {
	
	@Autowired
	private TaskManRepository pr;
	
	@Autowired
	private LabelRepository lr;
	

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);
	}
	
	@Bean
    CommandLineRunner runner(){
    	return new CommandLineRunner() {
			
			@Override
			public void run(String... arg0) throws Exception {
				
				/*
				 * Set the values by default
				 */
				Task task = new Task();
				task.setName("Morning");
				task.setLabel("Office");
				task.setPriority("Easy");
				pr.save(task);
				
				Label label = new Label();
				label.setLabel("Office");
				lr.save(label);
					
			}
		};
    }

}
