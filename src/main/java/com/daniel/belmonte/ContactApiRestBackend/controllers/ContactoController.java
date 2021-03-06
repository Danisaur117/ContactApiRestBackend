package com.daniel.belmonte.ContactApiRestBackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

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
		
		if(list == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="contactos/ap/{apellido}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<ContactoEntity>> getContactoByApellidos(@PathVariable String apellido){
		List<ContactoEntity> list = contactoService.getEntityByApellidos(apellido, apellido);
		
		if(list == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="contactos/{nombre}/{apellido1}/{apellido2}", method=RequestMethod.GET, produces="application/json")
	public ResponseEntity<List<ContactoEntity>> getContactoByNombreYApellidos(@PathVariable String nombre, @PathVariable String apellido1, @PathVariable String apellido2){
		List<ContactoEntity> list = contactoService.getEntityByNombreYApellidos(nombre, apellido1, apellido2);
		
		if(list == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value="contactos", method=RequestMethod.POST)
	public ResponseEntity<Void> addContacto(@RequestBody ContactoEntity contacto, UriComponentsBuilder builder){
		ContactoEntity contactoEntity = new ContactoEntity(contacto.getNombre(), contacto.getApellido1(),
														   contacto.getApellido2(), contacto.getTelefono());
		contacto = contactoService.addEntity(contactoEntity);
		
		if(contacto == null) return new ResponseEntity<>(null, HttpStatus.CONFLICT);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="contactos/{nombre}/{apellido1}/{apellido2}", method=RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<ContactoEntity> modifyContacto(@PathVariable String nombre, @PathVariable String apellido1, @PathVariable String apellido2, @RequestBody ContactoEntity contacto){
		List<ContactoEntity> list = contactoService.getEntityByNombreYApellidos(nombre, apellido1, apellido2);
		
		if(list == null) return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		if(list.size() > 1) return new ResponseEntity<>(null, HttpStatus.CONFLICT);
		
		ContactoEntity contactoRes = list.get(0);
		if(contacto.getNombre() != null) contactoRes.setNombre(contacto.getNombre());
		if(contacto.getApellido1() != null) contactoRes.setApellido1(contacto.getApellido1());
		if(contacto.getApellido2() != null) contactoRes.setApellido2(contacto.getApellido2());
		if(contacto.getTelefono() != 0) contactoRes.setTelefono(contacto.getTelefono());
		if(contacto.getDireccion() != null) contactoRes.setDireccion(contacto.getDireccion());
		if(contacto.getCodigoPostal() != 0) contactoRes.setCodigoPostal(contacto.getCodigoPostal());
		if(contacto.getCiudad() != null) contactoRes.setCiudad(contacto.getCiudad());
		if(contacto.getEmail() != null) contactoRes.setEmail(contacto.getEmail());
		Boolean updated = contactoService.updateEntity(contactoRes);
		
		return (updated)? new ResponseEntity<>(contactoRes, HttpStatus.OK):
			  			  new ResponseEntity<>(contactoRes, HttpStatus.CONFLICT);
	}
}
