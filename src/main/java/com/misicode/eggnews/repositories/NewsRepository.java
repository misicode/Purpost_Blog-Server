package com.misicode.eggnews.repositories;

import com.misicode.eggnews.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findByIsActiveTrueOrderByCreatedAtDesc();

    @Modifying
    @Query("UPDATE News n SET n.isActive = false WHERE n.idNews = :id")
    void softDelete(@Param("id") Long id);
}
