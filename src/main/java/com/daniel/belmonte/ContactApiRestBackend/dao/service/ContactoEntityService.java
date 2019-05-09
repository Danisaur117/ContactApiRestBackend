package com.daniel.belmonte.ContactApiRestBackend.dao.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.belmonte.ContactApiRestBackend.dao.entity.ContactoEntity;
import com.daniel.belmonte.ContactApiRestBackend.dao.interfaces.ContactoEntityInterface;
import com.daniel.belmonte.ContactApiRestBackend.dao.repository.ContactoEntityRepository;

@Service
@Transactional
public class ContactoEntityService implements ContactoEntityInterface {
	@Autowired
	private ContactoEntityRepository repository;
	
	public ContactoEntityService() {
		
	}
	
	public ContactoEntityService(ContactoEntityRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<ContactoEntity> getAllEntities(){
		List<ContactoEntity> list = new ArrayList<>();
		this.repository.findAll().forEach(e -> list.add(e));
		return list;
	}
	
	@Override
	public List<ContactoEntity> getEntityByNombre(String nombre){
		return this.repository.findByNombreContaining(nombre);
	}
	
	@Override
	public List<ContactoEntity> getEntityByApellidos(String apellido1, String apellido2){
		return this.repository.findByApellido1ContainingOrApellido2Containing(apellido1, apellido2);
	}
	
	@Override
	public List<ContactoEntity> getEntityByNombreYApellidos(String nombre, String apellido1, String apellido2){
		return this.repository.findByNombreAndApellido1AndApellido2(nombre, apellido1, apellido2);
	}
	
	@Override
	public ContactoEntity addEntity(ContactoEntity contacto) {
		try {
			return this.repository.save(contacto);
		}
		catch(Exception ex) {
//			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public boolean updateEntity(ContactoEntity contacto) {
		try {
			this.repository.save(contacto);
			return true;
		}
		catch(Exception ex) {
//			ex.printStackTrace();
			return false;
		}
	}
}
