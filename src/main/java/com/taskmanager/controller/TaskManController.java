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
		
	/*
	 * Get List of Task
	 */ 
	@RequestMapping(value = "/tasks", method= RequestMethod.GET)
	public List<Task> getListOfPost(){
		List<Task> posts = (List<Task>) taskmanrepository.findAll();			
		return posts;
	}
	
	/*
	 * POST Method which accept Task object 
	 * Persist Task object into database.
	 * return Task object with Id.  
	 */
	@RequestMapping(value = "/task", method = RequestMethod.POST)
	public Task savePost(@RequestBody Task tasks) {				
		return taskmanrepository.save(tasks);			
	}
	
	/*
	 * GET  Method which accept id 
	 * get Task object from database using Id.
	 * return Task object.  
	 */
	@RequestMapping(value="/task/{id}",method = RequestMethod.GET)
	public Task getPostById(@PathVariable(value="id") Long id){		
		return taskmanrepository.findOne(id);
	}
	
	/*
	 * DELETE Method which accept id 
	 * delete Task object from database using Id.
	 * return Success Message.  
	 */
	@RequestMapping(value="/task/{id}", method = RequestMethod.DELETE)
	public Map<String, String> deletePostById(@PathVariable Long id) {
		Map<String, String> message = new HashMap<String,String>();
		taskmanrepository.delete(id);
		message.put("message", "Task Deleted Successfully");
		return message;
	}
	
	/*
	 * PUT Method which accept id and Task object.  
	 * update Task object into database.
     * return Updated Task object.  
	 */
	 @RequestMapping(value="/task/{id}", method=RequestMethod.PUT)
	  public Task updatePost(@PathVariable Long id, @RequestBody Task tasks) {
		Task update = taskmanrepository.findOne(id);
	    return taskmanrepository.save(update);
	  }
	
}
