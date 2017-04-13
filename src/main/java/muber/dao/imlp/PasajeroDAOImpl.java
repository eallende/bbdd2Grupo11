package muber.dao.imlp;

import muber.dao.PasajeroDAO;
import muber.entities.Pasajero;
import muber.exception.DAOException;

public class PasajeroDAOImpl extends GenericDAOImpl<Pasajero> implements PasajeroDAO {

	public PasajeroDAOImpl() {
		super(Pasajero.class);
	}

}
