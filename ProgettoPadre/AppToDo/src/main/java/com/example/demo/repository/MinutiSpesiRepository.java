package com.example.demo.repository;

import com.example.demo.entity.MinutiSpesi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinutiSpesiRepository extends CrudRepository<MinutiSpesi,Long> {



}
