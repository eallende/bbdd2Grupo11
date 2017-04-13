package muber.dao.imlp;

import muber.dao.ConductorDAO;
import muber.entities.Conductor;
import muber.exception.DAOException;

public class ConductorDAOImpl extends GenericDAOImpl<Conductor> implements ConductorDAO {

	public ConductorDAOImpl() {
		super(Conductor.class);
	}

}
