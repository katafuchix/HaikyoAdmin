package com.example.haikyo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.haikyo.entity.HaikyoCategoryDocument;

public interface HaikyoCategoryService {

	public HaikyoCategoryDocument get(String id);
	
	public HaikyoCategoryDocument findByName(String name);
	
	public Page<HaikyoCategoryDocument> findAllBy(Pageable pageable);
	
	public Page<HaikyoCategoryDocument> findAll(Pageable pageable);
}
