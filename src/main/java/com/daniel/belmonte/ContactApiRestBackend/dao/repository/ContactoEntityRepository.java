package com.daniel.belmonte.ContactApiRestBackend.dao.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daniel.belmonte.ContactApiRestBackend.dao.entity.ContactoEntity;

@Repository
public interface ContactoEntityRepository extends CrudRepository<ContactoEntity, Integer> {
	public List<ContactoEntity> findByNombreContaining(String nombre);
	public List<ContactoEntity> findByApellido1ContainingOrApellido2Containing(String apellido1, String apellido2);
	public List<ContactoEntity> findByNombreAndApellido1AndApellido2(String nombre, String apellido1, String apellido2);
}
