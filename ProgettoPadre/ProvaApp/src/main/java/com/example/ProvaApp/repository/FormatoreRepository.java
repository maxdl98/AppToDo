package com.example.ProvaApp.repository;



import com.example.ProvaApp.entity.Formatore;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FormatoreRepository extends MongoRepository<Formatore,String> {





    Page<Formatore> findAll(Pageable pageable);


}
