package com.example.haikyo.repository;

import org.springframework.data.domain.Pageable;

import com.example.haikyo.entity.HaikyoCategoryDocument;

import reactor.core.publisher.Flux;

public interface CustomHaikyoCategoryRepository {

	Flux<HaikyoCategoryDocument> findAllByOrderByHaikyocategoryIdAsc(Pageable pageable);
}
