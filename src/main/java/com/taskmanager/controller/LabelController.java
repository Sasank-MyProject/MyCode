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
	
	//get all the date into list 
	@RequestMapping(value = "/labels", method= RequestMethod.GET)
	public List<Label> getListOfLabel(){
		List<Label> labels = (List<Label>) labelrepository.findAll();		
		System.out.println(labels);
		return labels;
	}
	
	@RequestMapping(value="/labels", method=RequestMethod.POST)
	 public Label saveLabel(@RequestBody Label labels) {
		return labelrepository.save(labels); 
	 }
}