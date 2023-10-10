package com.example.haikyo.repository;

import com.example.haikyo.entity.HaikyoCategoryDocument;
import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;

public interface HaikyoCategoryRepository extends FirestoreReactiveRepository<HaikyoCategoryDocument> {

}
