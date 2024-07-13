package com.example.haikyo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.haikyo.entity.HaikyoDocument;
import com.example.haikyo.repository.HaikyoRepository;

@Service
public class HaikyoServiceImpl implements HaikyoService {

    @Autowired
    HaikyoRepository repository;
    
    @Override
	public Page<HaikyoDocument> findAll(Pageable pageable) {
		return repository.findAllByOrderById(pageable).collectList()
				.zipWith(repository.count())
			    .map(p -> new PageImpl<>(p.getT1(), pageable, p.getT2())).block();
	}
}
