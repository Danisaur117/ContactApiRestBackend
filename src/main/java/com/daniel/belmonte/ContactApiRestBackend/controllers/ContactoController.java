package com.daniel.belmonte.ContactApiRestBackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.belmonte.ContactApiRestBackend.dao.entity.ContactoEntity;
import com.daniel.belmonte.ContactApiRestBackend.dao.service.ContactoEntityService;

@RestController
@RequestMapping("agenda")
public class ContactoController {
	@Autowired
	private ContactoEntityService contactoService;
	
	@RequestMapping(value="contactos", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<ContactoEntity>> getContactos(){
		List<ContactoEntity> list = contactoService.getAllEntities();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="contactos/{nombre}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<ContactoEntity>> getContactoByNombre(@PathVariable String nombre){
		List<ContactoEntity> list = contactoService.getEntityByNombre(nombre);
		
		if(list == null) return new ResponseEntity<>(null, HttpStatus.CONFLICT);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="contactos/ap/{apellido}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<ContactoEntity>> getContactoByApellidos(@PathVariable String apellido){
		List<ContactoEntity> list = contactoService.getEntityByApellidos(apellido, apellido);
		
		if(list == null) return new ResponseEntity<>(null, HttpStatus.CONFLICT);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
