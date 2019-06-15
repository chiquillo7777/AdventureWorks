package com.utec.beans;

import com.utec.dao.UsuarioDao;
import com.utec.model.Usuario;

public class UsuarioBean {
	
	private Usuario usuario = new Usuario();

	public UsuarioBean() {
		// TODO Auto-generated constructor stub
		
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String verificarDatos() throws Exception {
		
		UsuarioDao usuDao = new UsuarioDao();
		Usuario us;
		String resultado;
		
		try {
			us = usuDao.verificarDatos(this.usuario);
			if(us != null) {
				FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap.put("usuario", us);
				resultado = "exito";
			}else {
				resultado = "Error";
			}
		}catch(Exception e) {
			throw e;
		}
		return resultado;
	}

	
	
}
