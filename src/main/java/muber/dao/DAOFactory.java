package muber.dao;

import muber.dao.imlp.ConductorDAOImpl;
import muber.dao.imlp.MuberDAOImpl;
import muber.dao.imlp.PasajeroDAOImpl;
import muber.dao.imlp.UsuarioDAOImpl;
import muber.dao.imlp.ViajeDAOImpl;

public class DAOFactory {
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOImpl(); 
	}
	
	public static MuberDAO getMuberDAO() {
		return new MuberDAOImpl(); 
	}

	public static ViajeDAO getViajeDAO() {
		return new ViajeDAOImpl();
	}
	
	public static PasajeroDAO getPasajeroDAO(){
		return new PasajeroDAOImpl();
	}
	
	public static ConductorDAO getConductorDAO(){
		return new ConductorDAOImpl();
	}
}
