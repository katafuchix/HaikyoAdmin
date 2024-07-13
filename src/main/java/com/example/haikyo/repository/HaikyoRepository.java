package com.example.haikyo.repository;

import org.springframework.data.domain.Pageable;

import com.example.haikyo.entity.HaikyoDocument;
import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;

import reactor.core.publisher.Flux;

public interface HaikyoRepository extends FirestoreReactiveRepository<HaikyoDocument>{

	Flux<HaikyoDocument> findAllByOrderById(Pageable pageable);
}
