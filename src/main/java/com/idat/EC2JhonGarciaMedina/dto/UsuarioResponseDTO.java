package com.idat.EC2JhonGarciaMedina.dto;

public class UsuarioResponseDTO {
	
	private String token;

	public UsuarioResponseDTO(String token) {
		super();
		this.token = token;
	}

	public UsuarioResponseDTO() {
		super();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
	

}
