package com.example.haikyo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.haikyo.entity.HaikyoCategoryDocument;
import com.example.haikyo.repository.HaikyoCategoryRepository;

@Controller
public class IndexController {

    @Autowired
    HaikyoCategoryRepository repository;
    
	@GetMapping("/") 
	public String index() {
		
		System.out.println(repository.findAll().collectList().block());
		
		List<HaikyoCategoryDocument> list = repository.findAll().collectList().block();
		
		list.forEach(l -> {
			System.out.println(l);
			System.out.println(l.getName());
		});
		return "index";

	}
}
