package com.example.demo.repository;

import com.example.demo.entity.Adress;
import org.springframework.data.repository.CrudRepository;

public interface AdressRepository extends CrudRepository<Adress,Long> {
}
