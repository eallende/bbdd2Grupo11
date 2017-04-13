package muber.test.integration;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import muber.dao.ConductorDAO;
import muber.dao.DAOFactory;
import muber.dao.MuberDAO;
import muber.dao.PasajeroDAO;
import muber.dao.ViajeDAO;
import muber.entities.Calificacion;
import muber.entities.Conductor;
import muber.entities.Muber;
import muber.entities.Pasajero;
import muber.entities.Viaje;
import muber.exception.DAOException;
import muber.util.EstadoEnum;

public class MuberIntegrationTest {
	
	final static Logger log = Logger.getLogger(MuberIntegrationTest.class);
	static SessionFactory factory;
	private static Muber muber;

	public static void main(String[] args) {
		ConfigureLogger();
		CrearMuber();
		AllTestsCases();
	}
	
	private static void ConfigureLogger() {
		org.apache.log4j.BasicConfigurator.configure();
		Logger.getRootLogger().setLevel(Level.ERROR);
		Logger.getRootLogger().setLevel(Level.INFO);
	}
	
	private static void CrearMuber() {
		
		//Crear objeto Muber
		log.info("-----------Inicio de operación: crearMuber()---------");
		muber = new Muber();
		MuberDAO muberDAO = DAOFactory.getMuberDAO();
		try {
			muber = muberDAO.save(muber);
			log.info("----------Se creo el objeto Muber con id: " + muber.getIdMuber() + "------------");
			log.info("-----------Fin de operación: crearMuber()---------");
		} catch (DAOException e) {
			log.error("*******Error al crear el objeto Muber*********");
			e.toString();
		}
		
	}	

	private static void AllTestsCases() {
		
		
		//Crear conductor
		Conductor conductor = createConductorTest();
		
		//Agregar conductor a muber
		muber.getConductores().add((Conductor) conductor);
		
		//Crear Viaje
		Viaje viaje = createViajeTest();
		
		//Crear pasajeros
		Pasajero pasajeroGerman = createPasajeroTest("Germán", 1500.0);
		Pasajero pasajeroAlicia = createPasajeroTest("Alicia", 1500.0);
		Pasajero pasajeroMargarita = createPasajeroTest("Margarita", 1500.0);
		
		//Agregar pasajeros al viaje
		viaje.getPasajerosViaje().add(pasajeroGerman);
		viaje.getPasajerosViaje().add(pasajeroAlicia);
		viaje.getPasajerosViaje().add(pasajeroMargarita);
		
		//Agregar pasajeros a muber
		muber.getPasajeros().add(pasajeroGerman);
		muber.getPasajeros().add(pasajeroAlicia);
		muber.getPasajeros().add(pasajeroMargarita);
		
		//Agregar viaje a muber
		muber.getViajes().add(viaje);
		
		//Agregar conductor al viaje
		viaje.setConductorViaje(conductor);
		
		//Crear calificaciones
		Calificacion calificacionGerman = new Calificacion();
		calificacionGerman.setPasajero(pasajeroGerman);
		calificacionGerman.setPuntaje(5);
		calificacionGerman.setComentario("Muy bueno el viaje");
		calificacionGerman.setViaje(viaje);
		
		Calificacion calificacionAlicia = new Calificacion();
		calificacionGerman.setPasajero(pasajeroAlicia);
		calificacionGerman.setPuntaje(3);
		calificacionGerman.setComentario("Viaje regular");
		calificacionGerman.setViaje(viaje);
		
		Calificacion calificacionMargarita = new Calificacion();
		calificacionGerman.setPasajero(pasajeroMargarita);
		calificacionGerman.setPuntaje(4);
		calificacionGerman.setComentario("Viaje bueno");
		calificacionGerman.setViaje(viaje);
		
		//Agregar calificaciones al conductor
		conductor.getCalificacionesConductor().add(calificacionGerman);
		conductor.getCalificacionesConductor().add(calificacionAlicia);
		conductor.getCalificacionesConductor().add(calificacionMargarita);
		
		//Descontar crédito a pasajeros.
		finalizarViajeTest(viaje);
		
		
		
	}
	
	private static Conductor createConductorTest() {
		
		log.info("-----------Inicio de operación: crearConductorTest---------");
		Conductor conductor = new Conductor();
		conductor.setNombreUsuario("Roberto");
		conductor.setPassword("RobertoConductor");
		conductor.setFechaVencimientoLicencia(new Date());
		conductor.setFechaIngresoMuber(new Date());
		Conductor saveConductor = null;
		ConductorDAO conductorDAO = DAOFactory.getConductorDAO();
		try {
			saveConductor = conductorDAO.save(conductor);
			log.info("-----------Se creo el conductor id: " +saveConductor.getIdUsuario()+ "---------");
			log.info("-----------Fin de operación: crearConductorTest---------");
		} catch (DAOException e) {
			log.error("********Ocurrió un error al intentar guardar el conductor********");
			e.toString();
		}
		return saveConductor;
	}
	
	private static Viaje createViajeTest(){
		
		log.info("-----------Inicio de operación: createViajeTest---------");
		Viaje viaje = new Viaje();
		viaje.setOrigen("La Plata");
		viaje.setDestino("Tres Arroyos");
		viaje.setCantidadMaximaPasajeros(4);
		viaje.setCostoTotal(900.0);
		viaje.setEstado(EstadoEnum.ABIERTO.toString());
		Viaje saveViaje = null;
		ViajeDAO viajeDAO = DAOFactory.getViajeDAO();
		try {
			saveViaje = viajeDAO.save(viaje);
			log.info("-----------Se creo el viaje id: " +viaje.getIdViaje()+ "---------");
			log.info("-----------Fin de operación: createViajeTest---------");
		} catch (DAOException e) {
			log.error("********Ocurrió un error al intentar guardar el viaje********");
			e.toString();
		}
		return saveViaje;
		
	}
	
	private static Pasajero createPasajeroTest(String nombre, double credito) {
		
		log.info("-----------Inicio de operación: createPasajeroTest---------");
		Pasajero pasajero = new Pasajero();
		pasajero.setNombreUsuario(nombre);
		pasajero.getCreditoDisponible();
		PasajeroDAO pasajeroDAO = DAOFactory.getPasajeroDAO();
		Pasajero savePasajero = null;
		try{
			savePasajero = pasajeroDAO.save(pasajero);
			log.info("-----------Se creo el pasajero id: " +pasajero.getIdUsuario()+ "---------");
			log.info("-----------Fin de operación: createPasajeroTest---------");
		}catch (DAOException e){
			log.error("********Ocurrió un error al intentar guardar el pasajero: "+nombre+"********");
			e.toString();
		}
		return savePasajero;
	}
	
	private static void finalizarViajeTest(Viaje viaje){
		
		log.info("-----------Inicio de operación: finalizarViajeTest---------");
		List<Pasajero> pasajeros = viaje.getPasajerosViaje();
		double montoViaje = viaje.getCostoTotal() / viaje.getPasajerosViaje().size();
		for(Pasajero pasajero : pasajeros){
			pasajero.setCreditoDisponible(pasajero.getCreditoDisponible() - montoViaje);
		}
		
		viaje.setEstado(EstadoEnum.FINALIZADO.toString());
	}
}
