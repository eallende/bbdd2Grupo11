package muber.dao.imlp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import muber.dao.UsuarioDAO;
import muber.entities.Conductor;
import muber.entities.Usuario;
import muber.exception.DAOException;
import muber.hibernate.util.HibernateUtil;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements UsuarioDAO {
	
	public UsuarioDAOImpl(){
		super(Usuario.class);
	}

	
	
}
