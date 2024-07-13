package com.example.haikyo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.haikyo.entity.HaikyoDocument;

public interface HaikyoService {

	public Page<HaikyoDocument> findAll(Pageable pageable);
}
