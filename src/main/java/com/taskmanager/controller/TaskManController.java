package com.taskmanager.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.taskmanager.domain.Task;
import com.taskmanager.repository.TaskManRepository;

@RestController
public class TaskManController {

	@Autowired
	private TaskManRepository taskmanrepository;
	
	
		
	//get all the date into list 
	@RequestMapping(value = "/tasks", method= RequestMethod.GET)
	public List<Task> getListOfPost(){
		List<Task> posts = (List<Task>) taskmanrepository.findAll();			
		return posts;
	}
	
	@RequestMapping(value = "/task", method = RequestMethod.POST)
	public Task savePost(@RequestBody Task tasks) {				
		return taskmanrepository.save(tasks);			
	}
	
	@RequestMapping(value="/task/{id}",method = RequestMethod.GET)
	public Task getPostById(@PathVariable(value="id") Long id){		
		return taskmanrepository.findOne(id);
	}
	
	@RequestMapping(value="/task/{id}", method = RequestMethod.DELETE)
	public Map<String, String> deletePostById(@PathVariable Long id) {
		Map<String, String> message = new HashMap<String,String>();
		taskmanrepository.delete(id);
		message.put("message", "Task Deleted Successfully");
		return message;
	}
	
	
	 @RequestMapping(value="/task/{id}", method=RequestMethod.PUT)
	  public Task updatePost(@PathVariable Long id, @RequestBody Task tasks) {
		Task update = taskmanrepository.findOne(id);
	    return taskmanrepository.save(update);
	  }
	
}
