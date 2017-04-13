package muber.dao.imlp;

import muber.dao.ViajeDAO;
import muber.entities.Viaje;
import muber.exception.DAOException;

public class ViajeDAOImpl extends GenericDAOImpl<Viaje> implements ViajeDAO {

	public ViajeDAOImpl() {
		super(Viaje.class);
	}
}
