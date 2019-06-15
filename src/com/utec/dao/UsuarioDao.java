package com.utec.dao;


import org.hibernate.Session;
import org.hibernate.query.Query;


import com.utec.model.Usuario;
import com.utec.util.HibernateUtil;

public class UsuarioDao {
	
	private Session session;

	public UsuarioDao() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario verificarDatos(Usuario usuario) throws Exception {
		Usuario us = null;
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String hql = "FROM Usuario WHERE nombre = '" + usuario.getNombre()
			+ "' and clave = '" + usuario.getClave() + "'";
			Query query = session.createQuery(hql);
			if(!query.list().isEmpty()) {
				us = (Usuario) query.list().get(0);
			}
		}catch(Exception e) {
			throw e;
		}
		
		return us;
	}

}
