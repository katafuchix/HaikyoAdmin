package com.example.haikyo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.haikyo.entity.HaikyoDocument;
import com.example.haikyo.repository.HaikyoRepository;
import com.example.haikyo.service.HaikyoService;

@Controller
public class HaikyoController {

    @Autowired
    HaikyoRepository repository;
    
    @Autowired
	HaikyoService service;
    
	@GetMapping("/haikyo") 
	public String index(Model model, @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
	        @RequestParam(name = "size", required = false, defaultValue = "20") Integer size ) {
		/*
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
		*/
		
		Pageable pageable = Pageable.ofSize(size).withPage(page-1);
		Page<HaikyoDocument> p = service.findAll(pageable);
		model.addAttribute("p", p);
		 

		return "haikyo";
	}
}
