package com.daniel.belmonte.ContactApiRestBackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/hola")
	public String HolaMundo() {
		return "Hola mundo";
	}
	
	@RequestMapping(value="contactos", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<ContactoEntity>> getContactos(){
		List<ContactoEntity> list = contactoService.getAllEntities();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
