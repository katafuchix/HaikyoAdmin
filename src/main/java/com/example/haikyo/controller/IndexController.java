package com.example.haikyo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.haikyo.entity.HaikyoCategoryDocument;
import com.example.haikyo.repository.HaikyoCategoryRepository;
import com.example.haikyo.service.HaikyoCategoryService;

@Controller
public class IndexController {

    @Autowired
    HaikyoCategoryRepository repository;
    
    @Autowired
	HaikyoCategoryService service;
    
	@GetMapping("/") 
	public String index() {
		
		System.out.println(repository.findAll().collectList().block());
		
		List<HaikyoCategoryDocument> list = repository.findAll().collectList().block();
		
		list.forEach(l -> {
			System.out.println(l);
			System.out.println(l.getName());
		});
		
		for (HaikyoCategoryDocument d: list){
			  System.out.println(d);
			  //System.out.println(d);
			}
		
		Pageable pageable = Pageable.ofSize(10).withPage(0);
		System.out.println(service.findAll(pageable).getContent());
		return "index";

	}
}
