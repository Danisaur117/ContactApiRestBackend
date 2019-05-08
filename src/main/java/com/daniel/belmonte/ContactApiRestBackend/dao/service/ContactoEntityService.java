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
}
