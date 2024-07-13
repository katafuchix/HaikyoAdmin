package com.example.haikyo.repository;

import org.springframework.data.domain.Pageable;

import com.example.haikyo.entity.HaikyoCategoryDocument;
import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HaikyoCategoryRepository extends FirestoreReactiveRepository<HaikyoCategoryDocument>, CustomHaikyoCategoryRepository {

	Mono<HaikyoCategoryDocument> findById(Integer id);
	
	Mono<HaikyoCategoryDocument> findByName(String Name);
	
	Flux<HaikyoCategoryDocument> findAllByName(String Name, Pageable pageable);

	Flux<HaikyoCategoryDocument> findAllBy(Pageable pageable);
	
	Flux<HaikyoCategoryDocument> findAllByOrderById(Pageable pageable);
	
	Flux<HaikyoCategoryDocument> findAllByOrderByHaikyocategoryIdAsc(Pageable pageable);
}
