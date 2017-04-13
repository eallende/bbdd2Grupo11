package muber.dao.imlp;

import muber.dao.MuberDAO;
import muber.entities.Muber;

public class MuberDAOImpl extends GenericDAOImpl<Muber> implements MuberDAO {

	public MuberDAOImpl() {
		super(Muber.class);
	}

}


