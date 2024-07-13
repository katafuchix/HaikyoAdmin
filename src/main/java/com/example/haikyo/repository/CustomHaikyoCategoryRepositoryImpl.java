package com.example.haikyo.repository;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.example.haikyo.entity.HaikyoCategoryDocument;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;

import reactor.core.publisher.Flux;

@Repository
public class CustomHaikyoCategoryRepositoryImpl implements CustomHaikyoCategoryRepository {

    @Autowired
    private Firestore firestore;

    @Override
    public Flux<HaikyoCategoryDocument> findAllByOrderByHaikyocategoryIdAsc(Pageable pageable) {
        com.google.cloud.firestore.Query query = firestore.collection("haikyo_category")
                .orderBy("haikyo_category_id")
                .offset((int) pageable.getOffset())
                .limit(pageable.getPageSize());

        // クエリを非同期的に実行し、ApiFuture<QuerySnapshot>を返します。
        // ApiFutureは、Googleの非同期処理をサポートするインターフェースです。
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        // getHaikyoCategoryFromQuerySnapshot(querySnapshot)メソッドを使用して、
        // ApiFuture<QuerySnapshot>を処理し、QuerySnapshotからHaikyoCategoryオブジェクトのリストを取得します。
        // 取得したリストをFlux<HaikyoCategoryDocument>に変換
        return Flux.fromIterable(getHaikyoCategoryFromQuerySnapshot(querySnapshot));
    }

    private List<HaikyoCategoryDocument> getHaikyoCategoryFromQuerySnapshot(ApiFuture<QuerySnapshot> querySnapshot) {
        try {
            return querySnapshot.get() // 非同期クエリの結果を同期的に取得
            		.getDocuments() // クエリ結果のドキュメントを取得
            		.stream()
                    .map(document -> document.toObject(HaikyoCategoryDocument.class)) // 取得したドキュメントをHaikyoCategoryDocumentクラスのインスタンスに変換
                    .collect(Collectors.toList());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Failed to fetch users from Firestore", e);
        }
    }
}
