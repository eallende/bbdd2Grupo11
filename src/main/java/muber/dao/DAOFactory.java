package muber.dao;

import muber.dao.imlp.MuberDAOImpl;
import muber.dao.imlp.UsuarioDAOImpl;

public class DAOFactory {
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl(); 
	}
	
	public static MuberDAO getMuberDAO() {
		return new MuberDAOImpl(); 
	}
}
