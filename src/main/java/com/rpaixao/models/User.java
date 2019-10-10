package com.rpaixao.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {

    private static final long serialVersionUID = -2390806049989107785L;

    @Id
    private String id;
    
    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String documento;
    private String correo;
    private String telefono;

    public User() {
	super();
    }

    public User(String nombres, String apellidos, String tipoDocumento, String documento, String correo,
			String telefono) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.correo = correo;
		this.telefono = telefono;
	}



	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}



	public String getNombres() {
		return nombres;
	}



	public void setNombres(String nombres) {
		this.nombres = nombres;
	}



	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public String getTipoDocumento() {
		return tipoDocumento;
	}



	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}



	public String getDocumento() {
		return documento;
	}



	public void setDocumento(String documento) {
		this.documento = documento;
	}



	public String getCorreo() {
		return correo;
	}



	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	@Override
    public String toString() {
	return "User [nombres=" + nombres + ", apellidos=" + apellidos + ", tipoDocumento=" + tipoDocumento
		+ ", documento=" + documento + ", correo=" + correo + ", telefono=" + telefono + "]";
    }

}
