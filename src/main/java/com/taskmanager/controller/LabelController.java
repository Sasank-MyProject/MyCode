package com.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.domain.Label;
import com.taskmanager.repository.LabelRepository;

@RestController
public class LabelController {

	@Autowired
	private LabelRepository labelrepository;
	
	/*
	 * Get List of Label
	 */
	@RequestMapping(value = "/labels", method= RequestMethod.GET)
	public List<Label> getListOfLabel(){
		List<Label> labels = (List<Label>) labelrepository.findAll();		
		System.out.println(labels);
		return labels;
	}
	
	/*
	 * POST Method which accept Label object 
	 * Persist Label object into database.
	 * return Label object with Id.  
	 */
	@RequestMapping(value="/labels", method=RequestMethod.POST)
	 public Label saveLabel(@RequestBody Label labels) {
		return labelrepository.save(labels); 
	 }
}
