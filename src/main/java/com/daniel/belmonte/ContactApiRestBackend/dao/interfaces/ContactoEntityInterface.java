package com.daniel.belmonte.ContactApiRestBackend.dao.interfaces;

import java.util.List;

import com.daniel.belmonte.ContactApiRestBackend.dao.entity.ContactoEntity;

public interface ContactoEntityInterface {
	public List<ContactoEntity> getAllEntities();
	public List<ContactoEntity> getEntityByNombre(String nombre);
	public List<ContactoEntity> getEntityByApellidos(String apellido1, String apellido2);
	public List<ContactoEntity> getEntityByNombreYApellidos(String nombre, String apellido1, String apellido2);
	public ContactoEntity addEntity(ContactoEntity contacto);
}
