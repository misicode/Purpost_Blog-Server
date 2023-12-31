package com.misicode.eggnews.repositories;

import com.misicode.eggnews.domain.News;
import com.misicode.eggnews.domain.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends MongoRepository<News, String> {
    List<News> findByIsActiveTrueOrderByCreatedAtDesc();

    List<News> findByUserAndIsActiveTrueOrderByCreatedAtDesc(User user);

    @Query("{'_id' : id}")
    void softDelete(@Param("id") String id);
}
