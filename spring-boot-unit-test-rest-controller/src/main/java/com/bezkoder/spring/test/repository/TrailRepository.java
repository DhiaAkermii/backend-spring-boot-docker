package com.bezkoder.spring.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bezkoder.spring.test.model.Trail;


@Repository
public interface TrailRepository extends  JpaRepository<Trail,Integer>{
}