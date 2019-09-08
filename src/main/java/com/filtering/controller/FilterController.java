package com.filtering.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.filtering.model.Comment;
import com.filtering.service.WordsService;

import io.swagger.annotations.ApiOperation;

@RestController
public class FilterController {
	
	@Autowired
	WordsService service;
	
	@ApiOperation(value = "Validate the comment")
	@PostMapping("/comment")
	public String postComments(@Valid @RequestBody Comment comment)
	{
		boolean check = service.checkSpam(comment.getText());
		if(check)
		{
			return "Spam";
		}
		return "Not Spam";
	}
	
}
