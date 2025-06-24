package com.example.demo.repository;

import com.example.demo.entity.MateriePreferite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface MateriePreferiteRepository extends CrudRepository<MateriePreferite,Long> {


}
