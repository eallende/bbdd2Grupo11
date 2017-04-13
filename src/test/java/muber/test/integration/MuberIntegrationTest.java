package muber.test.integration;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;

import muber.dao.DAOFactory;
import muber.dao.MuberDAO;
import muber.dao.UsuarioDAO;
import muber.entities.Conductor;
import muber.entities.Muber;
import muber.entities.Usuario;
import muber.exception.DAOException;
import muber.hibernate.util.HibernateUtil;

public class MuberIntegrationTest {
	
	final static Logger logger = Logger.getLogger(MuberIntegrationTest.class);
	static SessionFactory factory;
	private static Muber muber;

	public static void main(String[] args) {
//		Configure();
		AllTestsCases();
	}
	
	private static void Configure() {
		//Crear objeto Muber
		muber = new Muber();
		MuberDAO muberDAO = DAOFactory.getMuberDAO();
		try {
			muber = muberDAO.save(muber);
			muber.getIdMuber();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	

	private static void AllTestsCases() {
		
		
		//Crear conductor
		createConductorTest();
		//Crear Viaje
		//Crear pasajeros
		//Agregar pasajeros al viaje
		//Crear calificaciones
		//Descontar crédito a pasajeros.
		
		
		
		
	}
	
	private static void createConductorTest() {
		
		Conductor conductor = new Conductor();
		conductor.setNombreUsuario("Roberto");
		conductor.setPassword("RobertoConductor");
		conductor.setFechaVencimientoLicencia(new Date());
		conductor.setFechaIngresoMuber(new Date());
		
		UsuarioDAO userDao = DAOFactory.getUsuarioDAO();
		try {
			Usuario saveConductor = userDao.save(conductor);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
 
	
}
