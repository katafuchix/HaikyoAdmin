package com.example.haikyo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.haikyo.entity.HaikyoCategoryDocument;

public interface HaikyoCategoryService {

	public HaikyoCategoryDocument get(String id);
	
	public HaikyoCategoryDocument findByName(String name);
	
	public List<HaikyoCategoryDocument> findAllBy(Pageable pageable);
	
	public Page<HaikyoCategoryDocument> findAll(Pageable pageable);
}
