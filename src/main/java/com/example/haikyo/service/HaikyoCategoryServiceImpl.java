package com.example.haikyo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.haikyo.entity.HaikyoCategoryDocument;
import com.example.haikyo.repository.HaikyoCategoryRepository;

@Service
public class HaikyoCategoryServiceImpl implements HaikyoCategoryService {

    @Autowired
    HaikyoCategoryRepository repository;
    
    @Override
	public HaikyoCategoryDocument get(String id) {
		return repository.findById(id).block();
	}
	
    @Override
	public HaikyoCategoryDocument findByName(String name) {
		return repository.findByName(name).block();
	}
	
	@Override
	public Page<HaikyoCategoryDocument> findAllBy(Pageable pageable){
		return repository.findAllBy(pageable).collectList()
				.zipWith(repository.count())
			    .map(p -> new PageImpl<>(p.getT1(), pageable, p.getT2())).block();
		
	}
	
	@Override
	public Page<HaikyoCategoryDocument> findAll(Pageable pageable){
		return repository//.findAllBy(pageable)
				.findAllByOrderByHaikyocategoryIdAsc(pageable)
				.collectList()
				.zipWith(repository.count())
			    .map(p -> new PageImpl<>(p.getT1(), pageable, p.getT2())).block();
	}
}
