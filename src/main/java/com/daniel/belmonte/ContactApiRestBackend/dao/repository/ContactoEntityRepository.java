package com.daniel.belmonte.ContactApiRestBackend.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daniel.belmonte.ContactApiRestBackend.dao.entity.ContactoEntity;

@Repository
public interface ContactoEntityRepository extends CrudRepository<ContactoEntity, Integer> {

}