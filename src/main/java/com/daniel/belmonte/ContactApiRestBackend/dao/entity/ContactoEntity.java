package com.daniel.belmonte.ContactApiRestBackend.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contacto")
public class ContactoEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contacto_id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int telefono;
	private String direccion;
	private int codigo_postal;
	private String ciudad;
	private String email;
	private Date last_update;
	
	public int getContactoId() {
		return contacto_id;
	}
	public void setContactoId(int contacto_id) {
		this.contacto_id = contacto_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getCodigoPostal() {
		return codigo_postal;
	}
	public void setCodigoPostal(int codigo_postal) {
		this.codigo_postal = codigo_postal;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getLastUpdate() {
		return last_update;
	}
	public void setLastUpdate(Date last_update) {
		this.last_update = last_update;
	}
}
