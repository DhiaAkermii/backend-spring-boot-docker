package com.bezkoder.spring.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bezkoder.spring.test.model.Hiker;


@Repository
public interface HikerRepository extends  JpaRepository<Hiker,Integer>{
}