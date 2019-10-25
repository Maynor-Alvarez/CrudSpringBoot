package com.maynoralvarez.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotEmpty
	@Length(min=5, max=24)
	private String nombre;
	@NotEmpty
	@Length(min=10, max=24)
	private String pasword;
	@NotEmpty
	@Email
	private String email;
	
	public Usuario() {
		super();
		
	}
	
	
	public Usuario(String nombre, String pasword, String email) {
		this.nombre=nombre;
		this.pasword=pasword;
		this.email=email;
	}


	public Long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getPasword() {
		return pasword;
	}


	public void setPasword(String pasword) {
		this.pasword = pasword;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
	
}
